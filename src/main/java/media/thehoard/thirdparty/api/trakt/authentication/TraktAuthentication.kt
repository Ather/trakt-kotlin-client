package media.thehoard.thirdparty.api.trakt.authentication

import com.github.salomonbrys.kotson.fromJson
import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.core.Constants
import media.thehoard.thirdparty.api.trakt.core.TraktConfiguration
import media.thehoard.thirdparty.api.trakt.enums.TraktAccessTokenGrantType
import media.thehoard.thirdparty.api.trakt.exceptions.*
import media.thehoard.thirdparty.api.trakt.extensions.containsSpace
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktError
import media.thehoard.thirdparty.api.trakt.utils.Json
import media.thehoard.thirdparty.api.trakt.utils.http.HttpMethod
import org.asynchttpclient.Dsl.asyncHttpClient
import org.asynchttpclient.Request
import org.asynchttpclient.RequestBuilder
import org.asynchttpclient.Response
import java.net.HttpURLConnection
import java.util.*
import java.util.concurrent.CompletableFuture


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

    fun checkIfAuthorizationIsExpiredOrWasRevokedAsync(autoRefresh: Boolean = false): CompletableFuture<Pair<Boolean, TraktAuthorization?>> {
        if (authorization.isExpired)
            return CompletableFuture.completedFuture(true to null)

        try {
            return client.sync.getLastActivitiesAsync().thenApply {
                false to null
            }
        } catch (e: TraktAuthorizationException) {
            if (!autoRefresh)
                return CompletableFuture.completedFuture(true to null)

            return refreshAuthorizationAsync().thenApply {
                true to it
            }
        }
    }

    fun checkIfAuthorizationIsExpiredOrWasRevokedAsync(authorization: TraktAuthorization?, autoRefresh: Boolean = false): CompletableFuture<Pair<Boolean, TraktAuthorization?>> {
        if (authorization == null)
            throw IllegalArgumentException("authorization")

        val currentAuthorization = authorization
        this.authorization = authorization

        return CompletableFuture.supplyAsync {
            val result: Pair<Boolean, TraktAuthorization?>

            try {
                result = checkIfAuthorizationIsExpiredOrWasRevokedAsync(autoRefresh).get()
            } finally {
                this.authorization = currentAuthorization
            }

            return@supplyAsync result
        }
    }

    fun checkIfAccessTokenWasRevokedOrIsNotValidAsync(accessToken: String): CompletableFuture<Boolean> {
        if (accessToken.isBlank() || accessToken.containsSpace())
            throw IllegalArgumentException("access token must not be null, empty, or contain any spaces")

        val currentAuthorization = authorization
        authorization = TraktAuthorization.createWith(accessToken)

        return try {
            client.sync.getLastActivitiesAsync()
            CompletableFuture.completedFuture(false)
        } catch (e: TraktAuthorizationException) {
            CompletableFuture.completedFuture(true)
        } finally {
            authorization = currentAuthorization
        }
    }

    fun refreshAuthorizationAsync(
            refreshToken: String? = authorization.refreshToken,
            clientId: String? = client.clientId,
            clientSecret: String? = client.clientSecret,
            redirectUri: String = this.redirectUri
    ): CompletableFuture<TraktAuthorization> {
        if (!isAuthorized && (refreshToken!!.isEmpty() || refreshToken.contains(" ")))
            throw TraktAuthorizationException("not authorized")

        if (refreshToken!!.isEmpty() || refreshToken.contains(" "))
            throw IllegalArgumentException("refresh token not valid")

        val grantType = TraktAccessTokenGrantType.REFRESH_TOKEN.objectName

        validateRefreshTokenInput(clientId, clientSecret, redirectUri, grantType)

        val postContent = "{{ \"refresh_token\": \"$refreshToken\", \"client_id\": \"$clientId\"," +
                " \"client_secret\": \"$clientSecret\", \"redirect_uri\": \"$redirectUri\"," +
                " \"grant_type\": \"$grantType\" }}"

        val httpClient = TraktConfiguration.httpClient ?: asyncHttpClient()

        val tokenUrl = "${client.configuration.baseUrl}${Constants.OAUTH_TOKEN_URI}"
        val request = RequestBuilder().setMethod(HttpMethod.POST.toString()).setBody(postContent).build()

        setDefaultRequestHeaders(request)

        return httpClient.executeRequest(request).toCompletableFuture().thenApply {
            val responseCode = it.statusCode
            val responseContent = it.responseBody ?: ""
            val reasonPhrase = it.statusText

            if (responseCode == HttpURLConnection.HTTP_OK) {
                var token = TraktAuthorization()
                if (!responseContent.isBlank())
                    token = Json.gson.fromJson(responseContent)

                client.authentication.authorization = token
                return@thenApply token
            } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                var error: TraktError? = null
                if (!responseContent.isBlank())
                    error = Json.gson.fromJson(responseContent)

                val errorMessage = if (error == null) "unknown error" else "error on refreshing oauth access token\nerror: ${error.error}\n" +
                        "description: ${error.description}"

                throw TraktAuthenticationException(errorMessage).apply {
                    statusCode = responseCode
                    requestUrl = tokenUrl
                    requestBody = postContent
                    serverReasonPhrase = reasonPhrase
                }
            }

            errorHandling(it, tokenUrl, postContent)
            return@thenApply TraktAuthorization()
        }
    }

    fun revokeAuthorizationAsync(
            accessToken: String = authorization.accessToken ?: "",
            clientId: String? = client.clientId
    ): CompletableFuture<Unit>? {
        if (!isAuthorized && (accessToken.isBlank() || accessToken.containsSpace()))
            throw TraktAuthorizationException("not authorized")

        if (accessToken.isBlank() || accessToken.containsSpace())
            throw IllegalArgumentException("access token not valid")

        if (clientId.isNullOrBlank() || clientId!!.containsSpace())
            throw IllegalArgumentException("client id not valid")

        val postContent = "token=$accessToken"
        val httpClient = TraktConfiguration.httpClient ?: asyncHttpClient()
        val request = RequestBuilder().setMethod(HttpMethod.POST.toString()).setBody(postContent).build()

        setDefaultRequestHeaders(request)
        setAuthorizationRequestHeaders(request, accessToken, clientId)

        val tokenUrl = "${client.configuration.baseUrl}${Constants.OAUTH_REVOKE_URL}"

        request.headers["Content-Type"] = "application/x-www-form-urlencoded"

        return httpClient.executeRequest(request).toCompletableFuture().thenApply {

            if (it.statusCode !in 200..299) {
                if (it.statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    val responseContent = it.responseBody ?: ""

                    throw TraktAuthenticationException("error on revoking access token").apply {
                        requestUrl = tokenUrl
                        requestBody = postContent
                        this.response = responseContent
                        serverReasonPhrase = it.statusText
                    }
                }
            }

            errorHandling(it, tokenUrl, postContent)
        }
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
        var responseContent = ""

        if (resp.responseBody != null)
            responseContent = resp.responseBody

        val code = resp.statusCode
        val reasonPhrase = resp.statusText

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
