package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktShowStatus(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("returning series")
    RETURNING_SERIES(1, "returning series", "returning series", "Returning Series"),
    @SerializedName("in production")
    IN_PRODUCTION(2, "in production", "in production", "In Production"),
    @SerializedName("canceled")
    CANCELED(4, "canceled", "canceled", "Canceled"),
    @SerializedName("ended")
    ENDED(8, "ended", "ended", "Ended");

    override fun toString() = displayName
}
