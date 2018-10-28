package com.atherapp.thirdparty.api.trakt.objects.authentication

import java.time.Instant

interface TraktDevice {
    var deviceCode: String

    var userCode: String

    var verificationUrl: String

    var expiresInSeconds: Int

    var intervalInSeconds: Int

    val intervalInMilliseconds: Int

    val isValid: Boolean

    val createdAt: Instant

    val isExpiredUnused: Boolean
}