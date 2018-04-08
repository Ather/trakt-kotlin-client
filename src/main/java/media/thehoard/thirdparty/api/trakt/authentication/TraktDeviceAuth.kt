package media.thehoard.thirdparty.api.trakt.authentication

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.core.Constants
import media.thehoard.thirdparty.api.trakt.core.TraktConfiguration
import media.thehoard.thirdparty.api.trakt.exceptions.*
import media.thehoard.thirdparty.api.trakt.extensions.containsSpace
import media.thehoard.thirdparty.api.trakt.utils.Json
import media.thehoard.thirdparty.api.trakt.utils.http.HttpMethod
import org.asynchttpclient.Dsl
import org.asynchttpclient.Request
import org.asynchttpclient.RequestBuilder
import org.asynchttpclient.Response
import java.net.HttpURLConnection
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

class TraktDeviceAuth internal constructor(val client: TraktClient) {
    fun generateDeviceAsync(clientId: String? = client.clientId): CompletableFuture<TraktDevice> {
        if (clientId.isNullOrBlank() || clientId!!.containsSpace())
            throw IllegalArgumentException("client id not valid")

        val postContent = "{{ \"client_id\": \"$clientId\" }}"

        val httpClient = TraktConfiguration.httpClient ?: Dsl.asyncHttpClient()

        val tokenUrl = "${client.configuration.baseUrl}${Constants.OAUTH_DEVICE_CODE_URI}"
        val request = RequestBuilder().setMethod(HttpMethod.POST.toString()).setBody(postContent).build()

        setDefaultRequestHeaders(request)

        return httpClient.executeRequest(request).toCompletableFuture().thenApply {
            if (it.statusCode !in 200..299)
                errorHandling(it, tokenUrl, postContent, true)

            val responseContent = it.responseBody

            var device = TraktDevice()

            if (!responseContent.isBlank())
                device = Json.deserialize(responseContent)

            client.authentication.device = device
            return@thenApply device
        }
    }

    fun pollForAuthorizationAsync(
            device: TraktDevice = client.authentication.device,
            clientId: String? = client.clientId,
            clientSecret: String? = client.clientSecret
    ): CompletableFuture<TraktAuthorization> {
        validateAccessTokenInput(device, clientId, clientSecret)

        val postContent = "{{ \"code\": \"${device.deviceCode}\", \"client_id\": \"$clientId\", \"client_secret\": \"$clientSecret\" }}"

        val httpClient = TraktConfiguration.httpClient ?: Dsl.asyncHttpClient()
        val request = RequestBuilder().setMethod(HttpMethod.POST.toString()).setBody(postContent).build()

        setDefaultRequestHeaders(request)

        val tokenUrl = "${client.configuration.baseUrl}${Constants.OAUTH_DEVICE_TOKEN_URI}"

        var responseCode: Int
        var responseContent: String
        var reasonPhrase = ""
        var totalExpiredSeconds = 0

        while (totalExpiredSeconds < device.expiresInSeconds ?: 0) {
            val response = httpClient.executeRequest(request).get()

            responseCode = response.statusCode
            responseContent = response.responseBody ?: ""
            reasonPhrase = response.statusText

            if (responseCode == HttpURLConnection.HTTP_OK) {
                var token = TraktAuthorization()
                if (!responseContent.isBlank())
                    token = Json.deserialize(responseContent)

                client.authentication.authorization = token
                return CompletableFuture.completedFuture(token)
            } else if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                Thread.sleep(TimeUnit.SECONDS.toMillis(device.intervalInSeconds?.toLong() ?: 0))
                totalExpiredSeconds += device.intervalInSeconds ?: 0
                continue
            }

            when (responseCode) {
                HttpURLConnection.HTTP_NOT_FOUND -> throw TraktAuthenticationDeviceException("Not Found - invalid device_code").apply {
                    statusCode = responseCode
                    requestUrl = tokenUrl
                    requestBody = postContent
                    serverReasonPhrase = reasonPhrase
                }
                HttpURLConnection.HTTP_CONFLICT -> throw TraktAuthenticationDeviceException("Already Used - user already approved this code").apply {
                    statusCode = responseCode
                    requestUrl = tokenUrl
                    requestBody = postContent
                    serverReasonPhrase = reasonPhrase
                }
                HttpURLConnection.HTTP_GONE -> throw TraktAuthenticationDeviceException("Expired - the tokens have expired, restart the process").apply {
                    statusCode = responseCode
                    requestUrl = tokenUrl
                    requestBody = postContent
                    serverReasonPhrase = reasonPhrase
                }
                418 -> throw TraktAuthenticationDeviceException("Denied - user explicitly denied this code").apply {
                    statusCode = responseCode
                    requestUrl = tokenUrl
                    requestBody = postContent
                    serverReasonPhrase = reasonPhrase
                }
                429 -> throw TraktAuthenticationDeviceException("Slow Down - your app is polling too quickly").apply {
                    statusCode = responseCode
                    requestUrl = tokenUrl
                    requestBody = postContent
                    serverReasonPhrase = reasonPhrase
                }
            }
            errorHandling(response, tokenUrl, postContent, true)
            break
        }

        throw TraktAuthenticationDeviceException("unknown exception").apply {
            serverReasonPhrase = reasonPhrase
        }
    }


    fun refreshAuthorizationAsync(
            refreshToken: String? = client.authentication.authorization.refreshToken,
            clientId: String? = client.clientId,
            clientSecret: String? = client.clientSecret,
            redirectUri: String = client.authentication.redirectUri
    ): CompletableFuture<TraktAuthorization> = client.authentication.refreshAuthorizationAsync(
            refreshToken,
            clientId,
            clientSecret,
            redirectUri
    )

    fun revokeAuthorizationAsync(
            accessToken: String = client.authentication.authorization.accessToken ?: "",
            clientId: String? = client.clientId
    ): CompletableFuture<Unit>? = client.authentication.revokeAuthorizationAsync(
            accessToken,
            clientId
    )

    private fun setDefaultRequestHeaders(request: Request) {
        request.headers["Content-Type"] = Constants.MEDIA_TYPE
        request.headers["Accept"] = Constants.MEDIA_TYPE
    }

    private fun validateAccessTokenInput(device: TraktDevice, clientId: String?, clientSecret: String?) {
        if (device.isExpiredUnused)
            throw IllegalArgumentException("device code expired unused")

        if (!device.isValid)
            throw IllegalArgumentException("device not valid")

        if (device.deviceCode?.containsSpace() == true)
            throw IllegalArgumentException("device code not valid")

        if (clientId.isNullOrBlank() || clientId!!.containsSpace())
            throw IllegalArgumentException("client id not valid")

        if (clientSecret.isNullOrBlank() || clientSecret!!.containsSpace())
            throw IllegalArgumentException("client secret not valid")
    }

    private fun errorHandling(resp: Response, reqUrl: String, reqContent: String, handleAdditionalCodes: Boolean) {
        var responseContent = ""

        if (resp.responseBody != null)
            responseContent = resp.responseBody

        val code = resp.statusCode
        val reasonPhrase = resp.statusText

        when (code) {
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

        if (handleAdditionalCodes) {
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
                429 -> throw TraktRateLimitException().apply {
                    requestUrl = reqUrl
                    requestBody = reqContent
                    response = responseContent
                    serverReasonPhrase = reasonPhrase
                }
            }
        }

        throw TraktAuthenticationDeviceException("unknown exception").apply {
            statusCode = code
            requestUrl = reqUrl
            requestBody = reqContent
            response = responseContent
            serverReasonPhrase = reasonPhrase
        }
    }
}
