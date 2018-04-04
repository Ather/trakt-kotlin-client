package media.thehoard.thirdparty.api.trakt.authentication

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.exceptions.*
import media.thehoard.thirdparty.api.trakt.extensions.containsSpace
import org.asynchttpclient.Response
import java.net.HttpURLConnection

class TraktOAuth internal constructor(val client: TraktClient) {
    fun createAuthorizationUrl(clientId: String = client.clientId, redirectUri: String = client.authentication.redirectUri): String {

    }

    private fun createEncodedAuthorizationUri(clientId: String, redirectUri: String, state: String? = null) {
        TODO() // Add URL encoding
        val uriParams = mutableMapOf<String, String>(
                "response_type" to "code",
                "client_id" to clientId,
                "redirect_uri" to redirectUri
        )

        if (!state.isNullOrBlank())
            uriParams["state"] = state!!
    }

    private fun buildAuthorizationUrl(clientId: String, redirectUri: String, state: String? = null): String {
    }

    private fun validateAuthorizationUrlArguments(clientId: String, redirectUri: String) {
        if (clientId.isBlank() || clientId.containsSpace())
            throw IllegalArgumentException("client id not valid")
        if (redirectUri.isBlank() || redirectUri.containsSpace())
            throw IllegalArgumentException("redirect uri not valid")
    }

    private fun validateAuthorizationUrlArguments(clientId: String, redirectUri: String, state: String) {
        validateAuthorizationUrlArguments(clientId, redirectUri)

        if (state.isBlank() || state.containsSpace())
            throw IllegalArgumentException("state not valid")
    }

    private fun validateAccessTokenInput(code: String, clientId: String, clientSecret: String, redirectUri: String, grantType: String) {
        if (code.isBlank() || code.containsSpace())
            throw IllegalArgumentException("code not valid")

        validateAuthorizationUrlArguments(clientId, redirectUri)

        if (clientSecret.isBlank() || clientSecret.containsSpace())
            throw IllegalArgumentException("client secret not valid")
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
}
