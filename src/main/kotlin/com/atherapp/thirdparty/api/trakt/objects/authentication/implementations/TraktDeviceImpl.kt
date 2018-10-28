package com.atherapp.thirdparty.api.trakt.objects.authentication.implementations

import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktDevice
import com.google.gson.annotations.SerializedName
import java.time.Instant

data class TraktDeviceImpl internal constructor(
        @SerializedName("device_code")
        override var deviceCode: String = "",
        @SerializedName("user_code")
        override var userCode: String = "",
        @SerializedName("verification_url")
        override var verificationUrl: String = "",
        @SerializedName("expires_in")
        override var expiresInSeconds: Int = 0,
        @SerializedName("interval")
        override var intervalInSeconds: Int = 0
): TraktDevice {
    override val intervalInMilliseconds: Int
        get() = intervalInSeconds * 1000
    override val isValid: Boolean
        get() = deviceCode.isNotBlank() && userCode.isNotBlank() && verificationUrl.isNotBlank() && !isExpiredUnused && intervalInSeconds > 0
    @Transient
    override val createdAt: Instant = Instant.now()
    override val isExpiredUnused: Boolean
        get() = createdAt.plusSeconds(expiresInSeconds.toLong()) <= Instant.now()
}