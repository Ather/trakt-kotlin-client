package com.atherapp.thirdparty.api.trakt.requests.handler

import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktDevice
import com.atherapp.thirdparty.api.trakt.requests.authentication.*
import com.atherapp.thirdparty.api.trakt.responses.TraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import kotlinx.coroutines.Deferred

internal interface IAuthenticationRequestHandler {
    fun createAuthorizationUrl(clientId: String, redirectUri: String, state: String? = null): String

    fun createAuthorizationUrlWithDefaultState(clientId: String, redirectUri: String): String

    fun checkIfAuthorizationIsExpiredOrWasRevokedAsync(authorization: TraktAuthorization, autoRefresh: Boolean = false): Deferred<Pair<Boolean, TraktResponse<TraktAuthorization>>>

    fun checkIfAuthorizationIsExpiredOrWasRevokedAsync(autoRefresh: Boolean = false): Deferred<Pair<Boolean, TraktResponse<TraktAuthorization>>>

    fun checkIfAccessTokenWasRevokedOrIsNotValidAsync(accessToken: String): Deferred<Boolean>

    fun getDeviceAsync(request: DeviceRequest): Deferred<TraktResponse<TraktDevice>>

    fun getAuthorizationAsync(request: AuthorizationRequest): Deferred<TraktResponse<TraktAuthorization>>

    fun pollForAuthorizationAsync(request: AuthorizationPollRequest): Deferred<TraktResponse<TraktAuthorization>>

    fun refreshAuthorizationAsync(request: AuthorizationRefreshRequest): Deferred<TraktResponse<TraktAuthorization>>

    fun revokeAuthorizationAsync(request: AuthorizationRevokeRequest): Deferred<TraktNoContentResponse>
}