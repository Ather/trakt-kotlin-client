package media.thehoard.thirdparty.api.trakt.authentication

import com.google.gson.annotations.SerializedName
import java.time.Instant

data class TraktDevice(
        @SerializedName("device_code")
        var deviceCode: String? = null,
        @SerializedName("user_code")
        var userCode: String? = null,
        @SerializedName("verification_url")
        var verificationUrl: String? = null,
        @SerializedName("expires_in")
        var expiresInSeconds: Int? = null,
        @SerializedName("interval")
        var intervalInSeconds: Int? = null
) {
    val isValid
        get() = !deviceCode.isNullOrBlank() && isExpiredUnused

    @Transient
    var created: Instant = Instant.now()
        internal set

    val isExpiredUnused
        get() = created.plusSeconds(expiresInSeconds?.toLong() ?: 0) <= Instant.now()

    override fun toString(): String = if (isValid) deviceCode!! else "no valid device code"
}
