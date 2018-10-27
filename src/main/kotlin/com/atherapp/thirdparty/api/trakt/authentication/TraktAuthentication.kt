package com.atherapp.thirdparty.api.trakt.authentication

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.core.Constants
import com.atherapp.thirdparty.api.trakt.enums.TraktAccessTokenGrantType
import com.atherapp.thirdparty.api.trakt.exceptions.*
import com.atherapp.thirdparty.api.trakt.extensions.containsSpace
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktError
import com.atherapp.thirdparty.api.trakt.utils.Json
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.net.HttpURLConnection
import java.nio.charset.Charset
import java.util.*


class TraktAuthentication(val client: TraktClient) {
    private var traktAuthorization: TraktAuthorization? = null
    private var traktDevice: TraktDevice? = null

    var oAuthAuthorizationCode: String? = null

    val antiForgeryToken = UUID.randomUUID().toString()

    var authorization: TraktAuthorization
        get() {
            if (traktAuthorization == null)
                traktAuthorization = TraktAuthorization()

            return traktAuthorization!!
        }
        set(value) {
            traktAuthorization = value
        }

    var device: TraktDevice
        get() {
            if (traktDevice == null)
                traktDevice = TraktDevice()

            return traktDevice!!
        }
        set(value) {
            traktDevice = value
        }

    var clientId: String? = null
    var clientSecret: String? = null

    var redirectUri = DEFAULT_REDIRECT_URI

    val isAuthorized: Boolean
        get() = !authorization.isExpired

    fun checkIfAuthorizationIsExpiredOrWasRevokedAsync(autoRefresh: Boolean = false): Deferred<Pair<Boolean, TraktAuthorization?>> = GlobalScope.async {
        if (authorization.isExpired)
            return@async true to null

        try {
            return@async client.sync.getLastActivitiesAsync().await().run {
                false to null
            }
        } catch (e: TraktAuthorizationException) {
            if (!autoRefresh)
                return@async true to null

            return@async refreshAuthorizationAsync().await().run {
                true to this
            }
        }
    }

    fun checkIfAuthorizationIsExpiredOrWasRevokedAsync(authorization: TraktAuthorization?, autoRefresh: Boolean = false): Deferred<Pair<Boolean, TraktAuthorization?>> {
        if (authorization == null)
            throw IllegalArgumentException("authorization")

        val currentAuthorization = authorization
        this.authorization = authorization

        return GlobalScope.async {
            val result: Pair<Boolean, TraktAuthorization?>

            try {
                result = checkIfAuthorizationIsExpiredOrWasRevokedAsync(autoRefresh).await()
            } finally {
                this@TraktAuthentication.authorization = currentAuthorization
            }

            return@async result
        }
    }

    fun checkIfAccessTokenWasRevokedOrIsNotValidAsync(accessToken: String): Deferred<Boolean> = GlobalScope.async {
        if (accessToken.isBlank() || accessToken.containsSpace())
            throw IllegalArgumentException("access token must not be null, empty, or contain any spaces")

        val currentAuthorization = authorization
        authorization = TraktAuthorization.createWith(accessToken)

        return@async try {
            client.sync.getLastActivitiesAsync().await()
            false
        } catch (e: TraktAuthorizationException) {
            true
        } finally {
            authorization = currentAuthorization
        }
    }

    fun refreshAuthorizationAsync(
            refreshToken: String? = authorization.refreshToken,
            clientId: String? = client.clientId,
            clientSecret: String? = client.clientSecret,
            redirectUri: String = this.redirectUri
    ): Deferred<TraktAuthorization> = GlobalScope.async {
        if (!isAuthorized && (refreshToken!!.isEmpty() || refreshToken.contains(" ")))
            throw TraktAuthorizationException("not authorized")

        if (refreshToken!!.isEmpty() || refreshToken.contains(" "))
            throw IllegalArgumentException("refresh token not valid")

        val grantType = TraktAccessTokenGrantType.REFRESH_TOKEN.objectName

        validateRefreshTokenInput(clientId, clientSecret, redirectUri, grantType)

        val postContent = "{{ \"refresh_token\": \"$refreshToken\", \"client_id\": \"$clientId\"," +
                " \"client_secret\": \"$clientSecret\", \"redirect_uri\": \"$redirectUri\"," +
                " \"grant_type\": \"$grantType\" }}"

        val tokenUrl = "${client.configuration.baseUrl}${Constants.OAUTH_TOKEN_URI}"
        val request = Fuel.post(tokenUrl).body(postContent)

        setDefaultRequestHeaders(request)

        val (_, response, _) = request.response()
        val responseCode = response.statusCode
        val responseContent = response.data.toString(Charset.forName("UTF-8"))
        val reasonPhrase = response.responseMessage

        if (responseCode == HttpURLConnection.HTTP_OK) {
            var token = TraktAuthorization()
            if (!responseContent.isBlank())
                token = Json.deserialize(responseContent)

            client.authentication.authorization = token
            return@async token
        } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
            var error: TraktError? = null
            if (!responseContent.isBlank())
                error = Json.deserialize(responseContent)

            val errorMessage = if (error == null) "unknown error" else "error on refreshing oauth access token\nerror: ${error.error}\n" +
                    "description: ${error.description}"

            throw TraktAuthenticationException(errorMessage).apply {
                statusCode = responseCode
                requestUrl = tokenUrl
                requestBody = postContent
                serverReasonPhrase = reasonPhrase
            }
        }

        errorHandling(response, tokenUrl, postContent)
        return@async TraktAuthorization()
    }

    fun revokeAuthorizationAsync(
            accessToken: String = authorization.accessToken ?: "",
            clientId: String? = client.clientId
    ): Deferred<Unit>? = GlobalScope.async {
        if (!isAuthorized && (accessToken.isBlank() || accessToken.containsSpace()))
            throw TraktAuthorizationException("not authorized")

        if (accessToken.isBlank() || accessToken.containsSpace())
            throw IllegalArgumentException("access token not valid")

        if (clientId.isNullOrBlank() || clientId!!.containsSpace())
            throw IllegalArgumentException("client id not valid")

        val postContent = "token=$accessToken"
        val tokenUrl = "${client.configuration.baseUrl}${Constants.OAUTH_REVOKE_URL}"
        val request = Fuel.post(tokenUrl).body(postContent)

        setDefaultRequestHeaders(request)
        setAuthorizationRequestHeaders(request, accessToken, clientId)

        request.headers["Content-Type"] = "application/x-www-form-urlencoded"

        val (_, response, _) = request.response()
        if (response.statusCode !in 200..299) {
            if (response.statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                val responseContent = response.data.toString(Charset.forName("UTF-8"))

                throw TraktAuthenticationException("error on revoking access token").apply {
                    requestUrl = tokenUrl
                    requestBody = postContent
                    this.response = responseContent
                    serverReasonPhrase = response.responseMessage
                }
            }
        }

        errorHandling(response, tokenUrl, postContent)
    }

    private fun setDefaultRequestHeaders(request: Request) {
        request.headers["Content-Type"] = Constants.MEDIA_TYPE
        request.headers["Accept"] = Constants.MEDIA_TYPE
    }

    private fun setAuthorizationRequestHeaders(request: Request, accessToken: String, clientId: String) {
        if (Constants.API_CLIENT_ID_HEADER_KEY !in request.headers)
            request.headers[Constants.API_CLIENT_ID_HEADER_KEY] = clientId
        if (Constants.API_VERSION_HEADER_KEY !in request.headers)
            request.headers[Constants.API_VERSION_HEADER_KEY] = "${client.configuration.apiVersion}"

        request.headers["Authorization"] = "Bearer $accessToken"
    }

    private fun validateRefreshTokenInput(clientId: String?, clientSecret: String?, redirectUri: String, grantType: String) {
        if (clientId.isNullOrBlank() || clientId!!.containsSpace())
            throw IllegalArgumentException("client id not valid")
        if (clientSecret.isNullOrBlank() || clientSecret!!.containsSpace())
            throw IllegalArgumentException("client secret not valid")
        if (redirectUri.isBlank() || redirectUri.containsSpace())
            throw IllegalArgumentException("redirect uri not valid")
        if (grantType.isBlank())
            throw IllegalArgumentException("grant type not valid")
    }

    private fun errorHandling(resp: Response, reqUrl: String, reqContent: String) {
        val responseContent = resp.data.toString(Charset.forName("UTF-8"))

        val code = resp.statusCode
        val reasonPhrase = resp.responseMessage

        when (code) {
            HttpURLConnection.HTTP_NOT_FOUND -> throw TraktNotFoundException("Resource not found").apply {
                requestUrl = reqUrl
                requestBody = reqContent
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_BAD_REQUEST -> throw TraktBadRequestException().apply {
                requestUrl = reqUrl
                requestBody = reqContent
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_CONFLICT -> throw TraktConflictException().apply {
                requestUrl = reqUrl
                requestBody = reqContent
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_FORBIDDEN -> throw TraktForbiddenException().apply {
                requestUrl = reqUrl
                requestBody = reqContent
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_BAD_METHOD -> throw TraktMethodNotFoundException().apply {
                requestUrl = reqUrl
                requestBody = reqContent
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_INTERNAL_ERROR -> throw TraktServerException().apply {
                requestUrl = reqUrl
                requestBody = reqContent
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_BAD_GATEWAY -> throw TraktBadGatewayException().apply {
                requestUrl = reqUrl
                requestBody = reqContent
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_PRECON_FAILED -> throw TraktPreconditionFailedException().apply {
                requestUrl = reqUrl
                requestBody = reqContent
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            422 -> throw TraktValidationException().apply {
                requestUrl = reqUrl
                requestBody = reqContent
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            429 -> throw TraktRateLimitException().apply {
                requestUrl = reqUrl
                requestBody = reqContent
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_UNAVAILABLE, HttpURLConnection.HTTP_GATEWAY_TIMEOUT -> throw TraktServerUnavailableException("Service Unavailable - server overloaded (try again in 30s)").apply {
                requestUrl = reqUrl
                requestBody = reqContent
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            520, 521, 522 -> throw TraktServerUnavailableException("Service Unavailable - Cloudflare error").apply {
                requestUrl = reqUrl
                requestBody = reqContent
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
        }

        throw TraktAuthenticationException("unknown exception").apply {
            serverReasonPhrase = reasonPhrase
        }
    }

    companion object {
        private const val DEFAULT_REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob"
    }
}
