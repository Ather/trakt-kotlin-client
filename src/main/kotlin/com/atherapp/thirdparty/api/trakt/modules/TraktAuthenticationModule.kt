package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.core.Constants
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktDevice
import com.atherapp.thirdparty.api.trakt.objects.authentication.implementations.TraktAuthorizationImpl
import com.atherapp.thirdparty.api.trakt.objects.authentication.implementations.TraktDeviceImpl
import com.atherapp.thirdparty.api.trakt.requests.authentication.*
import com.atherapp.thirdparty.api.trakt.requests.handler.AuthenticationRequestHandler
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import kotlinx.coroutines.Deferred
import java.util.*

class TraktAuthenticationModule internal constructor(override val client: TraktClient) : TraktModule {

    private var _authorization: TraktAuthorization? = null
    private var _device: TraktDevice? = null

    var oAuthAuthorizationCode: String? = null

    var authorization: TraktAuthorization
        get() {
            if (_authorization == null)
                _authorization = TraktAuthorizationImpl()
            return _authorization!!
        }
        set(value) {
            _authorization = value
        }
    var device: TraktDevice
        get() {
            if (_device == null)
                _device = TraktDeviceImpl()
            return _device!!
        }
        set(value) {
            _device = value
        }

    val antiForgeryToken = UUID.randomUUID().toString()

    var clientId: String? = null

    var clientSecret: String? = null

    var redirectUri: String = Constants.DEFAULT_REDIRECT_URI

    val isAuthorized: Boolean
        get() = _authorization?.isExpired == false

    fun checkIfAuthorizationIsExpiredOrWasRevokedAsync(autoRefresh: Boolean = false): Deferred<Pair<Boolean, TraktResponse<TraktAuthorization>>> =
            AuthenticationRequestHandler(client).checkIfAuthorizationIsExpiredOrWasRevokedAsync(autoRefresh)

    fun checkIfAuthorizationIsExpiredOrWasRevokedAsync(authorization: TraktAuthorization, autoRefresh: Boolean = false): Deferred<Pair<Boolean, TraktResponse<TraktAuthorization>>> =
            AuthenticationRequestHandler(client).checkIfAuthorizationIsExpiredOrWasRevokedAsync(authorization, autoRefresh)

    fun checkIfAccessTokenWasRevokedOrIsNotValidAsync(accessToken: String): Deferred<Boolean> =
            AuthenticationRequestHandler(client).checkIfAccessTokenWasRevokedOrIsNotValidAsync(accessToken)

    fun createAuthorizationUrl(
            clientId: String = this.clientId ?: "",
            redirectUri: String = this.redirectUri,
            state: String? = null
    ) = AuthenticationRequestHandler(client).createAuthorizationUrl(clientId, redirectUri, state)

    fun createAuthorizationUrlWithDefaultState(
            clientId: String = this.clientId ?: "",
            redirectUri: String = this.redirectUri
    ) = AuthenticationRequestHandler(client).createAuthorizationUrlWithDefaultState(clientId, redirectUri)

    fun getAuthorizationAsync(
            code: String = oAuthAuthorizationCode ?: "",
            clientId: String = this.clientId ?: "",
            clientSecret: String = this.clientSecret ?: "",
            redirectUri: String = this.redirectUri
    ) = AuthenticationRequestHandler(client).getAuthorizationAsync(AuthorizationRequest(code, redirectUri, clientId, clientSecret))

    fun generateDeviceAsync(
            clientId: String = this.clientId ?: ""
    ) = AuthenticationRequestHandler(client).getDeviceAsync(DeviceRequest(clientId))

    fun pollForAuthorizationAsync(
            device: TraktDevice = this.device,
            clientId: String = this.clientId ?: "",
            clientSecret: String = this.clientSecret ?: ""
    ) = AuthenticationRequestHandler(client).pollForAuthorizationAsync(AuthorizationPollRequest(device, clientId, clientSecret))

    fun refreshAuthorizationAsync(
            refreshToken: String = authorization.refreshToken,
            clientId: String = this.clientId ?: "",
            clientSecret: String = this.clientSecret ?: "",
            redirectUri: String = this.redirectUri
    ) = AuthenticationRequestHandler(client).refreshAuthorizationAsync(AuthorizationRefreshRequest(refreshToken, redirectUri, clientId, clientSecret))

    fun revokeAuthorizationAsync(
            accessToken: String = authorization.accessToken,
            clientId: String = this.clientId ?: "",
            clientSecret: String = this.clientSecret ?: ""
    ) = AuthenticationRequestHandler(client).revokeAuthorizationAsync(AuthorizationRevokeRequest(accessToken, clientId, clientSecret))
}