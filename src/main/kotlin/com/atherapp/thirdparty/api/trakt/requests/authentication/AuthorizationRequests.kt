package com.atherapp.thirdparty.api.trakt.requests.authentication

import com.atherapp.thirdparty.api.trakt.enums.TraktAccessTokenGrantType
import com.atherapp.thirdparty.api.trakt.extensions.containsSpace
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktDevice
import com.atherapp.thirdparty.api.trakt.requests.base.APostRequestHasResponse
import com.atherapp.thirdparty.api.trakt.requests.base.AuthorizationRequirement
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody
import kotlin.reflect.KClass

internal abstract class AbstractAuthorizationRequest<TResponseContentType : Any, TRequestBodyType : IRequestBody>(
        override val uriTemplate: String,
        responseContentClass: KClass<TResponseContentType>,
        override var requestBody: TRequestBodyType?
) : APostRequestHasResponse<TResponseContentType, TRequestBodyType>(responseContentClass) {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.NotRequired

    override val uriPathParameters: Map<String, Any>? = null
}

internal class AuthorizationPollRequest(
        device: TraktDevice,
        clientId: String,
        clientSecret: String
) : AbstractAuthorizationRequest<TraktAuthorization, AuthorizationPollRequestBody>(
        "oauth/device/token",
        TraktAuthorization::class,
        AuthorizationPollRequestBody(device, clientId, clientSecret)
)

internal class AuthorizationPollRequestBody(
        private val device: TraktDevice,
        private val clientId: String,
        private val clientSecret: String
) : IRequestBody {
    private val httpContentAsString = "{{ \"code\": \"${device.deviceCode}\", \"client_id\": \"$clientId\", \"client_secret\": \"$clientSecret\" }}"

    override fun validate(variableName: String) {
        if (device.isExpiredUnused)
            throw IllegalArgumentException("device code expired unused")
        if (!device.isValid)
            throw IllegalArgumentException("device not valid")
        if (device.deviceCode.containsSpace())
            throw IllegalArgumentException("device code not valid")
        if (clientId.isBlank() || clientId.containsSpace())
            throw IllegalArgumentException("client id not valid")
        if (clientSecret.isBlank() || clientSecret.containsSpace())
            throw IllegalArgumentException("client secret not valid")
    }

    override fun toJson() = httpContentAsString
}

internal class AuthorizationRefreshRequest(
        refreshToken: String,
        redirectUri: String,
        clientId: String,
        clientSecret: String
) : AbstractAuthorizationRequest<TraktAuthorization, AuthorizationRefreshRequestBody>(
        "oauth/token",
        TraktAuthorization::class,
        AuthorizationRefreshRequestBody(refreshToken, redirectUri, clientId, clientSecret)
)

internal class AuthorizationRefreshRequestBody(
        private val refreshToken: String,
        private val redirectUri: String,
        private val clientId: String,
        private val clientSecret: String
) : IRequestBody {
    private val httpContentAsString = "{{ \"refresh_token\": \"$refreshToken\", \"client_id\": \"$clientId\"," +
            " \"client_secret\": \"$clientSecret\", \"redirect_uri\": \"$redirectUri\"," +
            " \"grant_type\": \"${TraktAccessTokenGrantType.REFRESH_TOKEN.objectName}\" }}"

    override fun validate(variableName: String) {
        if (refreshToken.isBlank() || refreshToken.containsSpace())
            throw IllegalArgumentException("refresh token not valid")
        if (redirectUri.isBlank() || redirectUri.containsSpace())
            throw IllegalArgumentException("redirect uri not valid")
        if (clientId.isBlank() || clientId.containsSpace())
            throw IllegalArgumentException("client id not valid")
        if (clientSecret.isBlank() || clientSecret.containsSpace())
            throw IllegalArgumentException("client secret not valid")
    }

    override fun toJson() = httpContentAsString
}