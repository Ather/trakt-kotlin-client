package com.atherapp.thirdparty.api.trakt.requests.handler

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.core.Constants
import com.atherapp.thirdparty.api.trakt.exceptions.TraktAuthenticationDeviceException
import com.atherapp.thirdparty.api.trakt.exceptions.TraktAuthenticationException
import com.atherapp.thirdparty.api.trakt.exceptions.TraktAuthenticationOAuthException
import com.atherapp.thirdparty.api.trakt.exceptions.TraktAuthorizationException
import com.atherapp.thirdparty.api.trakt.extensions.containsSpace
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktDevice
import com.atherapp.thirdparty.api.trakt.objects.authentication.implementations.TraktAuthorizationImpl
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktError
import com.atherapp.thirdparty.api.trakt.objects.basic.implementations.TraktErrorImpl
import com.atherapp.thirdparty.api.trakt.requests.authentication.*
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody
import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IPostRequestHasResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import com.atherapp.thirdparty.api.trakt.utils.Json
import com.github.kittinunf.fuel.core.isSuccessful
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import java.net.HttpURLConnection
import java.net.URLEncoder
import java.nio.charset.Charset

internal class AuthenticationRequestHandler(private val client: TraktClient) : IAuthenticationRequestHandler {
    private val requestMessageBuilder = RequestMessageBuilder(client)

    override fun createAuthorizationUrl(clientId: String, redirectUri: String, state: String?): String {
        validateAuthorizationUrlArguments(clientId, redirectUri, state)
        return buildAuthorizationUrl(clientId, redirectUri, state)
    }

    override fun createAuthorizationUrlWithDefaultState(clientId: String, redirectUri: String): String {
        val state = client.authentication.antiForgeryToken
        return createAuthorizationUrl(clientId, redirectUri, state)
    }

    override fun checkIfAuthorizationIsExpiredOrWasRevokedAsync(authorization: TraktAuthorization, autoRefresh: Boolean): Deferred<Pair<Boolean, TraktResponse<TraktAuthorization>>> = GlobalScope.async {
        val currentAuth = client.authorization
        client.authorization = authorization

        var result = true to TraktResponse<TraktAuthorization>(TraktAuthorization::class)

        try {
            result = checkIfAuthorizationIsExpiredOrWasRevokedAsync(autoRefresh).await()

            if (result.first && autoRefresh && result.second.isSuccess)
                client.authorization = result.second.value!!
        } finally {
            if (result.first)
                client.authorization = currentAuth
        }

        return@async result
    }

    override fun checkIfAuthorizationIsExpiredOrWasRevokedAsync(autoRefresh: Boolean): Deferred<Pair<Boolean, TraktResponse<TraktAuthorization>>> = GlobalScope.async {
        if (client.authorization.isExpired)
            return@async true to TraktResponse<TraktAuthorization>(TraktAuthorization::class)

        var throwResponseExceptions = true

        try {
            throwResponseExceptions = client.configuration.throwResponseExceptions
            client.configuration.throwResponseExceptions = true
            client.sync.getLastActivitiesAsync().await()
        } catch (e: TraktAuthorizationException) {
            if (!autoRefresh)
                return@async true to TraktResponse<TraktAuthorization>(TraktAuthorization::class)

            val request = AuthorizationRefreshRequest(
                    client.authorization.refreshToken,
                    client.authentication.redirectUri,
                    client.clientId ?: "",
                    client.clientSecret ?: ""
            )

            val response = refreshAuthorizationAsync(request).await()
            return@async response.isSuccess to response
        } finally {
            client.configuration.throwResponseExceptions = throwResponseExceptions
        }

        return@async false to TraktResponse<TraktAuthorization>(TraktAuthorization::class)
    }

    override fun checkIfAccessTokenWasRevokedOrIsNotValidAsync(accessToken: String): Deferred<Boolean> = GlobalScope.async {
        if (accessToken.isBlank() || accessToken.containsSpace())
            throw IllegalArgumentException("access token must not be empty or contain any spaces")

        val currentAuth = client.authorization
        client.authorization = TraktAuthorizationImpl.createWith(accessToken = accessToken)

        var throwResponseExceptions = true

        try {
            throwResponseExceptions = client.configuration.throwResponseExceptions
            client.configuration.throwResponseExceptions = true
            client.sync.getLastActivitiesAsync().await()
            return@async false
        } catch (e: TraktAuthorizationException) {
            return@async true
        } finally {
            client.configuration.throwResponseExceptions = throwResponseExceptions
            client.authorization = currentAuth
        }
    }

    override fun getDeviceAsync(request: DeviceRequest): Deferred<TraktResponse<TraktDevice>> = GlobalScope.async {
        try {
            request.validate()

            val requestMessage = requestMessageBuilder.reset(request).apply {
                requestBody = request.requestBody
                useAPIVersionHeader = false
                useAPIClientIdHeader = false
            }.build()

            val (_, responseMessage, _) = requestMessage.request.response()

            if (!responseMessage.isSuccessful)
                ResponseErrorHandler.handleErrorsAsync(requestMessage, responseMessage, isDeviceRequest = true).await()

            val responseData = responseMessage.data.toString(Charset.forName("UTF-8"))
            val device = if (responseData.isBlank()) null else Json.deserialize<TraktDevice>(responseData)

            val response = TraktResponse<TraktDevice>(TraktDevice::class).apply {
                value = device
                hasValue = device != null
                isSuccess = device != null
            }

            ResponseHeaderParser.parseResponseHeaderValues(response, responseMessage.headers)

            if (device != null) client.authentication.device = device
            return@async response
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e
            return@async TraktResponse<TraktDevice>(TraktDevice::class).apply {
                isSuccess = false
                exception = e
            }
        }
    }

    override fun getAuthorizationAsync(request: AuthorizationRequest): Deferred<TraktResponse<TraktAuthorization>> = executeAuthorizationRequestAsync(request, false)

    override fun pollForAuthorizationAsync(request: AuthorizationPollRequest): Deferred<TraktResponse<TraktAuthorization>> = GlobalScope.async {
        try {
            request.validate()

            val requestBuilder = requestMessageBuilder.reset(request).apply {
                requestBody = request.requestBody
                useAPIVersionHeader = false
                useAPIClientIdHeader = false
            }

            var requestMessage = requestBuilder.build()
            var totalExpiredInSeconds = 0

            var reasonPhrase: String? = null

            val device = request.requestBody!!.device

            while (totalExpiredInSeconds < device.expiresInSeconds) {
                val responseMessage = requestMessage.request.response().second

                val responseCode = responseMessage.statusCode
                reasonPhrase = responseMessage.responseMessage

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    val responseData = responseMessage.data.toString(Charset.forName("UTF-8"))
                    val traktAuth = if (responseData.isBlank()) null else Json.deserialize<TraktAuthorization>(responseData)

                    val response = TraktResponse<TraktAuthorization>(TraktAuthorization::class).apply {
                        value = traktAuth
                        hasValue = traktAuth != null
                        isSuccess = traktAuth != null
                    }

                    ResponseHeaderParser.parseResponseHeaderValues(response, responseMessage.headers)

                    if (traktAuth != null)
                        client.authentication.authorization = traktAuth
                    return@async response
                } else if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                    delay(device.intervalInMilliseconds.toLong())
                    totalExpiredInSeconds += device.intervalInSeconds
                    requestMessage = requestBuilder.build()
                    continue
                }

                ResponseErrorHandler.handleErrorsAsync(requestMessage, responseMessage, isInAuthorizationPolling = true).await()
                break
            }

            throw TraktAuthenticationDeviceException("unknown exception").apply {
                requestUrl = requestMessage.request.url.toString()
                requestBody = requestMessage.requestBodyJson
                serverReasonPhrase = reasonPhrase
            }
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e
            return@async TraktResponse<TraktAuthorization>(TraktAuthorization::class).apply {
                isSuccess = false
                exception = e
            }
        }
    }

    override fun refreshAuthorizationAsync(request: AuthorizationRefreshRequest): Deferred<TraktResponse<TraktAuthorization>> = executeAuthorizationRequestAsync(request, true)

    override fun revokeAuthorizationAsync(request: AuthorizationRevokeRequest): Deferred<TraktNoContentResponse> = GlobalScope.async {
        try {
            request.validate()

            val requestMessage = requestMessageBuilder.reset(request).apply {
                requestBody = request.requestBody
                useAPIVersionHeader = false
                useAPIClientIdHeader = false
            }.build()

            val responseMessage = requestMessage.request.response().second

            if (!responseMessage.isSuccessful) {
                if (responseMessage.statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    val respContent = responseMessage.data.toString(Charset.forName("UTF-8"))
                    throw TraktAuthenticationException("error on revoking access token").apply {
                        requestUrl = requestMessage.request.url.toString()
                        requestBody = requestMessage.requestBodyJson
                        response = respContent
                        serverReasonPhrase = responseMessage.responseMessage
                    }
                }

                ResponseErrorHandler.handleErrorsAsync(requestMessage, responseMessage, isAuthorizationRevoke = true).await()
            } else {
                client.authorization = TraktAuthorizationImpl.createWith(accessToken = "", refreshToken = "")

                return@async TraktNoContentResponse().apply {
                    isSuccess = true
                }
            }

            throw TraktAuthenticationException("unknown exception").apply {
                statusCode = responseMessage.statusCode
                requestUrl = requestMessage.request.url.toString()
                requestBody = requestMessage.requestBodyJson
                serverReasonPhrase = responseMessage.responseMessage
            }
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e
            return@async TraktNoContentResponse().apply {
                isSuccess = false
                exception = e
            }
        }
    }

    private fun <TRequestBodyType : IRequestBody> executeAuthorizationRequestAsync(
            request: IPostRequestHasResponse<TraktAuthorization, TRequestBodyType>,
            isRefreshRequest: Boolean
    ) = GlobalScope.async {
        try {
            request.validate()

            val requestMessage = requestMessageBuilder.reset(request).apply {
                requestBody = request.requestBody
                useAPIVersionHeader = false
                useAPIClientIdHeader = false
            }.build()

            val (_, responseMessage, _) = requestMessage.request.response()

            if (responseMessage.statusCode == HttpURLConnection.HTTP_OK) {
                val responseData = responseMessage.data.toString(Charset.forName("UTF-8"))
                val auth = if (responseData.isBlank()) null else Json.deserialize<TraktAuthorization>(responseData)

                val response = TraktResponse<TraktAuthorization>(TraktAuthorization::class).apply {
                    value = auth
                    hasValue = auth != null
                    isSuccess = auth != null
                }

                ResponseHeaderParser.parseResponseHeaderValues(response, responseMessage.headers)

                if (auth != null) client.authentication.authorization = auth
                return@async response
            } else if (responseMessage.statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                val responseData = responseMessage.data.toString(Charset.forName("UTF-8"))
                val error: TraktError? = if (responseData.isBlank()) null else Json.deserialize<TraktErrorImpl>(responseData)

                val errMessage = if (error != null) "error on ${if (isRefreshRequest) "refreshing" else "retrieving"} oauth access token\nerror: ${error.error}\ndescription: ${error.description}" else "unknown error"

                throw TraktAuthenticationOAuthException(errMessage).apply {
                    statusCode = responseMessage.statusCode
                    requestUrl = requestMessage.request.url.toString()
                    requestBody = requestMessage.requestBodyJson
                    serverReasonPhrase = responseMessage.responseMessage
                }
            }

            ResponseErrorHandler.handleErrorsAsync(requestMessage, responseMessage, isAuthorizationRequest = true).await()
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e
            return@async TraktResponse<TraktAuthorization>(TraktAuthorization::class).apply {
                isSuccess = false
                exception = e
            }
        }

        return@async TraktResponse<TraktAuthorization>(TraktAuthorization::class)
    }

    private fun createEncodedAuthorizationUri(clientId: String, redirectUri: String, state: String? = null): String {
        val uriParams = mutableListOf(
                "response_type" to "code",
                "client_id" to clientId,
                "redirect_uri" to redirectUri
        )

        if (!state.isNullOrBlank())
            uriParams += "state" to state!!

        val encodedUri = uriParams
                .map { (key, value) -> URLEncoder.encode(key, "UTF-8") to URLEncoder.encode(value, "UTF-8") }
                .joinToString("&") { (key, value) -> "$key=$value" }

        if (encodedUri.isBlank())
            throw IllegalArgumentException("authorization uri not valid")

        return "?$encodedUri"
    }

    private fun buildAuthorizationUrl(clientId: String, redirectUri: String, state: String? = null): String {
        val encodedUriParams = createEncodedAuthorizationUri(clientId, redirectUri, state)
        val isStagingUsed = client.configuration.useSandboxEnvironment
        val baseUrl = if (isStagingUsed) Constants.OAUTH_BASE_AUTHORIZE_STAGING_URL else Constants.OAUTH_BASE_AUTHORIZE_URL
        return "$baseUrl/${Constants.OAUTH_AUTHORIZE_URI}$encodedUriParams"
    }

    private fun validateAuthorizationUrlArguments(clientId: String, redirectUri: String, state: String? = null) {
        if (clientId.isBlank() || clientId.containsSpace())
            throw IllegalArgumentException("client id not valid")
        if (redirectUri.isBlank() || redirectUri.containsSpace())
            throw IllegalArgumentException("redirect uri not valid")
        if (state != null && (state.isBlank() || state.containsSpace()))
            throw IllegalArgumentException("state not valid")
    }
}