package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktReleaseType(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("unknown")
    UNKNOWN(1, "unknown", "unknown", "Unknown"),
    @SerializedName("premiere")
    PREMIERE(2, "premiere", "premiere", "Premiere"),
    @SerializedName("limited")
    LIMITED(4, "limited", "limited", " Limited"),
    @SerializedName("theatrical")
    THEATRICAL(8, "theatrical", "theatrical", "Theatrical"),
    @SerializedName("digital")
    DIGITAL(16, "digital", "digital", "Digital"),
    @SerializedName("physical")
    PHYSICAL(32, "physical", "physical", "Physical"),
    @SerializedName("tv")
    TV(64, "tv", "tv", "TV")
}
