package com.atherapp.thirdparty.api.trakt.requests.handler

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.core.Constants
import com.atherapp.thirdparty.api.trakt.exceptions.TraktAuthorizationException
import com.atherapp.thirdparty.api.trakt.extensions.containsSpace
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktDevice
import com.atherapp.thirdparty.api.trakt.requests.authentication.*
import com.atherapp.thirdparty.api.trakt.responses.TraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.net.URLEncoder

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

    override fun checkIfAuthorizationIsExpiredOrWasRevokedAsync(autoRefresh: Boolean): Deferred<Pair<Boolean, TraktResponse<TraktAuthorization>>> {
        TODO("not implemented")
    }

    override fun checkIfAccessTokenWasRevokedOrIsNotValidAsync(accessToken: String): Deferred<Boolean> {
        TODO("not implemented")
    }

    override fun getDeviceAsync(request: DeviceRequest): Deferred<TraktResponse<TraktDevice>> {
        TODO("not implemented")
    }

    override fun getAuthorizationAsync(request: AuthorizationRequest): Deferred<TraktResponse<TraktAuthorization>> {
        TODO("not implemented")
    }

    override fun pollForAuthorizationAsync(request: AuthorizationPollRequest): Deferred<TraktResponse<TraktAuthorization>> {
        TODO("not implemented")
    }

    override fun refreshAuthorizationAsync(request: AuthorizationRefreshRequest): Deferred<TraktResponse<TraktAuthorization>> {
        TODO("not implemented")
    }

    override fun revokeAuthorizationAsync(request: AuthorizationRevokeRequest): Deferred<TraktNoContentResponse> {
        TODO("not implemented")
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