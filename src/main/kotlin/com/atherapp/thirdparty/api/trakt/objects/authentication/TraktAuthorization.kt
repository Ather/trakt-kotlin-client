package com.atherapp.thirdparty.api.trakt.objects.authentication

import com.atherapp.thirdparty.api.trakt.enums.TraktAccessScope
import com.atherapp.thirdparty.api.trakt.enums.TraktAccessTokenType
import com.atherapp.thirdparty.api.trakt.objects.authentication.implementations.TraktAuthorizationImpl
import java.time.Instant
import java.time.ZonedDateTime

interface TraktAuthorization {
    var accessToken: String

    var refreshToken: String

    var accessScope: TraktAccessScope

    var expiresInSeconds: Int

    var tokenType: TraktAccessTokenType

    var createdAtTimestamp: Long

    val isExpired: Boolean

    val isValid: Boolean

    val isRefreshPossible: Boolean

    val createdAt: Instant

    var ignoreExpiration: Boolean

    interface Companion {
        fun createWith(createdAt: Instant = Instant.now(), expiresInSeconds: Int = TraktAuthorizationImpl.DEFAULT_EXPIRES_IN_SECONDS, accessToken: String, refreshToken: String? = null) : TraktAuthorization
    }
}
