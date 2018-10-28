package com.atherapp.thirdparty.api.trakt.objects.authentication.implementations

import com.atherapp.thirdparty.api.trakt.enums.TraktAccessScope
import com.atherapp.thirdparty.api.trakt.enums.TraktAccessTokenType
import com.atherapp.thirdparty.api.trakt.extensions.containsSpace
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.google.gson.annotations.SerializedName
import java.time.Instant

data class TraktAuthorizationImpl(
        @SerializedName("access_token")
        override var accessToken: String = "",
        @SerializedName("refresh_token")
        override var refreshToken: String = "",
        @SerializedName("scope")
        override var accessScope: TraktAccessScope = TraktAccessScope.PUBLIC,
        @SerializedName("expires_in")
        override var expiresInSeconds: Int = DEFAULT_EXPIRES_IN_SECONDS,
        @SerializedName("token_type")
        override var tokenType: TraktAccessTokenType = TraktAccessTokenType.BEARER
) : TraktAuthorization {
    override val createdAt: Instant
        get() = Instant.ofEpochMilli(createdAtTimestamp)
    @Transient
    override var createdAtTimestamp: Long = System.currentTimeMillis()
    @Transient
    override var ignoreExpiration: Boolean = false

    override val isExpired: Boolean
        get() = !isValid || (if (ignoreExpiration) false else (createdAt.plusSeconds(expiresInSeconds.toLong()) <= Instant.now()))
    override val isValid: Boolean
        get() = !accessToken.isBlank() && !accessToken.containsSpace()
    override val isRefreshPossible: Boolean
        get() = !refreshToken.isBlank() && !refreshToken.containsSpace()

    override fun toString(): String {
        var value = if (isValid) accessToken else "no valid access token"
        value += if (isExpired) " (expired)" else " (valid until ${createdAt.plusSeconds(expiresInSeconds.toLong())})"
        return value
    }

    companion object : TraktAuthorization.Companion {
        override fun createWith(createdAt: Instant, expiresInSeconds: Int, accessToken: String, refreshToken: String?): TraktAuthorization {
            val auth = TraktAuthorizationImpl(accessToken, refreshToken
                ?: "", TraktAccessScope.PUBLIC, expiresInSeconds, TraktAccessTokenType.BEARER)

            if (refreshToken == null)
                auth.ignoreExpiration = true

            return auth
        }

        internal const val DEFAULT_EXPIRES_IN_SECONDS = 7776000
    }
}