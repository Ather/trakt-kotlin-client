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
import java.net.URLEncoder
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

class TraktOAuth internal constructor(val client: TraktClient) {
    fun createAuthorizationUrl(
            clientId: String? = client.clientId,
            redirectUri: String = client.authentication.redirectUri,
            state: String? = client.authentication.antiForgeryToken
    ): String {
        if (state == null)
            validateAuthorizationUrlArguments(clientId, redirectUri)
        else
            validateAuthorizationUrlArguments(clientId, redirectUri, state)

        return buildAuthorizationUrl(clientId, redirectUri, state)
    }

    fun createAuthorizationUrlWithDefaultState(
            clientId: String? = client.clientId,
            redirectUri: String = client.authentication.redirectUri
    ): String {
        val state = client.authentication.antiForgeryToken

        return createAuthorizationUrl(clientId, redirectUri, state)
    }

    fun getAuthorizationAsync(
            code: String? = client.authentication.oAuthAuthorizationCode,
            clientId: String? = client.clientId,
            clientSecret: String? = client.clientSecret,
            redirectUri: String = client.authentication.redirectUri
    ): Deferred<TraktAuthorization> = GlobalScope.async {
        val grantType = TraktAccessTokenGrantType.AUTHORIZATION_CODE.objectName

        validateAccessTokenInput(code, clientId, clientSecret, redirectUri, grantType)

        val postContent = "{{ \"code\": \"$code\", \"client_id\": \"$clientId\", " +
                "\"client_secret\": \"$clientSecret\", \"redirect_uri\": " +
                "\"$redirectUri\", \"grant_type\": \"$grantType\" }}"

        val tokenUrl = "${client.configuration.baseUrl}${Constants.OAUTH_TOKEN_URI}"
        val request = Fuel.post(tokenUrl).body(postContent)

        setDefaultRequestHeaders(request)

        val response = request.response().second
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

            val errorMessage = if (error == null) "unknown error" else "error on retrieving oauth access token\nerror: ${error.error}\n" +
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


    fun refreshAuthorizationAsync(
            refreshToken: String? = client.authentication.authorization.refreshToken,
            clientId: String? = client.clientId,
            clientSecret: String? = client.clientSecret,
            redirectUri: String = client.authentication.redirectUri
    ): Deferred<TraktAuthorization> = client.authentication.refreshAuthorizationAsync(
            refreshToken,
            clientId,
            clientSecret,
            redirectUri
    )

    fun revokeAuthorizationAsync(
            accessToken: String = client.authentication.authorization.accessToken ?: "",
            clientId: String? = client.clientId
    ): Deferred<Unit>? = client.authentication.revokeAuthorizationAsync(
            accessToken,
            clientId
    )

    private fun setDefaultRequestHeaders(request: Request) {
        request.headers["Content-Type"] = Constants.MEDIA_TYPE
        request.headers["Accept"] = Constants.MEDIA_TYPE
    }

    private fun createEncodedAuthorizationUri(clientId: String?, redirectUri: String, state: String? = null): String {
        val uriParams = mutableMapOf(
                "response_type" to "code",
                "client_id" to clientId,
                "redirect_uri" to redirectUri
        )

        if (!state.isNullOrBlank())
            uriParams["state"] = state!!

        val encodedUri = uriParams.map { (k, v) -> k + "=" + URLEncoder.encode(v, StandardCharsets.UTF_8.toString()) }.joinToString("&")

        if (encodedUri.isBlank())
            throw IllegalArgumentException("authorization uri not valid")

        return "?$encodedUri"
    }

    private fun buildAuthorizationUrl(clientId: String?, redirectUri: String, state: String? = null): String {
        val encodedUriParams = createEncodedAuthorizationUri(clientId, redirectUri, state)
        val isStagingUsed = client.configuration.useSandboxEnvironment
        val baseUrl = if (isStagingUsed) Constants.OAUTH_BASE_AUTHORIZE_STAGING_URL else Constants.OAUTH_BASE_AUTHORIZE_URL
        return "$baseUrl/${Constants.OAUTH_AUTHORIZE_URI}$encodedUriParams"
    }

    private fun validateAuthorizationUrlArguments(clientId: String?, redirectUri: String) {
        if (clientId.isNullOrBlank() || clientId!!.containsSpace())
            throw IllegalArgumentException("client id not valid")
        if (redirectUri.isBlank() || redirectUri.containsSpace())
            throw IllegalArgumentException("redirect uri not valid")
    }

    private fun validateAuthorizationUrlArguments(clientId: String?, redirectUri: String, state: String) {
        validateAuthorizationUrlArguments(clientId, redirectUri)

        if (state.isBlank() || state.containsSpace())
            throw IllegalArgumentException("state not valid")
    }

    private fun validateAccessTokenInput(code: String?, clientId: String?, clientSecret: String?, redirectUri: String, grantType: String) {
        if (code.isNullOrBlank() || code!!.containsSpace())
            throw IllegalArgumentException("code not valid")

        validateAuthorizationUrlArguments(clientId, redirectUri)

        if (clientSecret.isNullOrBlank() || clientSecret!!.containsSpace())
            throw IllegalArgumentException("client secret not valid")
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

        throw TraktAuthenticationOAuthException("unknown exception").apply {
            serverReasonPhrase = reasonPhrase
        }
    }
}
