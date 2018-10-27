package com.atherapp.thirdparty.api.trakt.authentication

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.core.Constants
import com.atherapp.thirdparty.api.trakt.exceptions.*
import com.atherapp.thirdparty.api.trakt.extensions.containsSpace
import com.atherapp.thirdparty.api.trakt.utils.Json
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import java.net.HttpURLConnection
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit

class TraktDeviceAuth internal constructor(val client: TraktClient) {
    fun generateDeviceAsync(clientId: String? = client.clientId): Deferred<TraktDevice> = GlobalScope.async {
        if (clientId.isNullOrBlank() || clientId!!.containsSpace())
            throw IllegalArgumentException("client id not valid")

        val postContent = "{{ \"client_id\": \"$clientId\" }}"

        val tokenUrl = "${client.configuration.baseUrl}${Constants.OAUTH_DEVICE_CODE_URI}"
        val request = Fuel.post(tokenUrl).body(postContent)

        setDefaultRequestHeaders(request)

        val (_, response, _) = request.response()
        if (response.statusCode !in 200..299)
            errorHandling(response, tokenUrl, postContent, true)

        val responseContent = response.data.toString(Charset.forName("UTF-8"))

        var device = TraktDevice()

        if (!responseContent.isBlank())
            device = Json.deserialize(responseContent)

        client.authentication.device = device
        return@async device
    }

    fun pollForAuthorizationAsync(
            device: TraktDevice = client.authentication.device,
            clientId: String? = client.clientId,
            clientSecret: String? = client.clientSecret
    ): Deferred<TraktAuthorization> {
        validateAccessTokenInput(device, clientId, clientSecret)

        val postContent = "{{ \"code\": \"${device.deviceCode}\", \"client_id\": \"$clientId\", \"client_secret\": \"$clientSecret\" }}"

        val tokenUrl = "${client.configuration.baseUrl}${Constants.OAUTH_DEVICE_TOKEN_URI}"

        val request = Fuel.post(tokenUrl).body(postContent)

        setDefaultRequestHeaders(request)

        var responseCode: Int
        var responseContent: String
        var reasonPhrase = ""
        var totalExpiredSeconds = 0

        return GlobalScope.async {
            while (totalExpiredSeconds < device.expiresInSeconds ?: 0) {
                val response = request.response().second

                responseCode = response.statusCode
                responseContent = response.data.toString(Charset.forName("UTF-8"))
                reasonPhrase = response.responseMessage

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    var token = TraktAuthorization()
                    if (!responseContent.isBlank())
                        token = Json.deserialize(responseContent)

                    client.authentication.authorization = token
                    return@async token
                } else if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                    delay(TimeUnit.SECONDS.toMillis(device.intervalInSeconds?.toLong() ?: 0))
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
        val responseContent = resp.data.toString(Charset.forName("UTF-8"))

        val code = resp.statusCode
        val reasonPhrase = resp.responseMessage

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
