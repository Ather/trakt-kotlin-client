package com.atherapp.thirdparty.api.trakt.authentication

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.enums.TraktAccessScope
import com.atherapp.thirdparty.api.trakt.enums.TraktAccessTokenType
import com.atherapp.thirdparty.api.trakt.extensions.containsSpace
import java.time.ZonedDateTime

data class TraktAuthorization(
        @SerializedName("access_token")
        var accessToken: String? = null,
        @SerializedName("refresh_token")
        var refreshToken: String? = null,
        @SerializedName("scope")
        var accessScope: TraktAccessScope? = null,
        @SerializedName("expires_in")
        var expiresInSeconds: Int? = null,
        @SerializedName("token_type")
        var tokenType: TraktAccessTokenType? = null
) {

    val isExpired
        get() = !isValid || (if (ignoreExpiration) false else (created.plusSeconds(expiresInSeconds?.toLong()
                ?: 0) <= ZonedDateTime.now()))

    val isValid
        get() = !accessToken.isNullOrBlank() && !accessToken!!.containsSpace()

    @Transient
    var created: ZonedDateTime = ZonedDateTime.now()
        internal set

    @Transient
    internal var ignoreExpiration: Boolean = false

    override fun toString(): String {
        val validUntil = created.plusSeconds(expiresInSeconds?.toLong() ?: 0)
        val strIsExpired = if (isExpired) "(expired)" else "(valid until $validUntil)"
        return if (isValid) "$accessToken $strIsExpired" else "no valid access token $strIsExpired"
    }

    companion object {
        fun createWith(accessToken: String, refreshToken: String? = "") = TraktAuthorization(
                accessScope = TraktAccessScope.PUBLIC,
                tokenType = TraktAccessTokenType.BEARER,
                accessToken = accessToken,
                refreshToken = refreshToken
        ).apply { ignoreExpiration = true }

        fun createWith(expiresInSeconds: Int, accessToken: String, refreshToken: String? = null) = TraktAuthorization(
                expiresInSeconds = expiresInSeconds,
                accessScope = TraktAccessScope.PUBLIC,
                tokenType = TraktAccessTokenType.BEARER,
                accessToken = accessToken,
                refreshToken = refreshToken ?: ""
        )

        fun createWith(createdAt: ZonedDateTime, accessToken: String, refreshToken: String? = null) =
                createWith(createdAt, 7776000, accessToken, refreshToken)

        fun createWith(createdAt: ZonedDateTime, expiresInSeconds: Int, accessToken: String, refreshToken: String? = null) = TraktAuthorization(
                expiresInSeconds = expiresInSeconds,
                accessScope = TraktAccessScope.PUBLIC,
                tokenType = TraktAccessTokenType.BEARER,
                accessToken = accessToken,
                refreshToken = refreshToken ?: ""
        ).apply {
            created = createdAt
        }
    }
}
