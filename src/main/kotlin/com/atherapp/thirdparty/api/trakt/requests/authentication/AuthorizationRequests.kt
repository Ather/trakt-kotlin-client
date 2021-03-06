package com.atherapp.thirdparty.api.trakt.requests.authentication

import com.atherapp.thirdparty.api.trakt.enums.TraktAccessTokenGrantType
import com.atherapp.thirdparty.api.trakt.extensions.containsSpace
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktDevice
import com.atherapp.thirdparty.api.trakt.requests.base.APostRequest
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
        val device: TraktDevice,
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

internal class AuthorizationRequest(
        code: String,
        redirectUri: String,
        clientId: String,
        clientSecret: String
) : AbstractAuthorizationRequest<TraktAuthorization, AuthorizationRequestBody>(
        "oauth/token",
        TraktAuthorization::class,
        AuthorizationRequestBody(code, redirectUri, clientId, clientSecret)
)

internal class AuthorizationRequestBody(
        private val code: String,
        private val redirectUri: String,
        private val clientId: String,
        private val clientSecret: String
) : IRequestBody {
    private val httpContentAsString = "{{ \"code\": \"$code\", \"client_id\": \"$clientId\"," +
            " \"client_secret\": \"$clientSecret\", \"redirect_uri\": \"$redirectUri\"," +
            " \"grant_type\": \"${TraktAccessTokenGrantType.AUTHORIZATION_CODE.objectName}\" }}"

    override fun validate(variableName: String) {
        if (code.isBlank() || code.containsSpace())
            throw IllegalArgumentException("code not valid")
        if (redirectUri.isBlank() || redirectUri.containsSpace())
            throw IllegalArgumentException("redirect uri not valid")
        if (clientId.isBlank() || clientId.containsSpace())
            throw IllegalArgumentException("client id not valid")
        if (clientSecret.isBlank() || clientSecret.containsSpace())
            throw IllegalArgumentException("client secret not valid")
    }

    override fun toJson() = httpContentAsString
}

internal class AuthorizationRevokeRequest(
        accessToken: String,
        clientId: String,
        clientSecret: String
) : APostRequest<AuthorizationRevokeRequestBody>() {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.NotRequired

    override val uriTemplate: String = "oauth/revoke"

    override var requestBody: AuthorizationRevokeRequestBody? = AuthorizationRevokeRequestBody(accessToken, clientId, clientSecret)

    override val uriPathParameters: Map<String, Any>? = null
}

internal class AuthorizationRevokeRequestBody(
        private val accessToken: String,
        private val clientId: String,
        private val clientSecret: String
) : IRequestBody {
    private val httpContentAsString = "{{ \"token\": \"$accessToken\", \"client_id\": \"$clientId\"," +
            " \"client_secret\": \"$clientSecret\" }}"

    override fun validate(variableName: String) {
        if (accessToken.isBlank() || accessToken.containsSpace())
            throw IllegalArgumentException("code not valid")
        if (clientId.isBlank() || clientId.containsSpace())
            throw IllegalArgumentException("client id not valid")
        if (clientSecret.isBlank() || clientSecret.containsSpace())
            throw IllegalArgumentException("client secret not valid")
    }

    override fun toJson() = httpContentAsString
}

internal class DeviceRequest(
        clientId: String
) : AbstractAuthorizationRequest<TraktDevice, DeviceRequestBody>(
        "oauth/device/code",
        TraktDevice::class,
        DeviceRequestBody(clientId)
)

internal class DeviceRequestBody(
        private val clientId: String
) : IRequestBody {
    private val httpContentAsString = "{{ \"client_id\": \"$clientId\" }}"

    override fun validate(variableName: String) {
        if (clientId.isBlank() || clientId.containsSpace())
            throw IllegalArgumentException("client id not valid")
    }

    override fun toJson() = httpContentAsString
}