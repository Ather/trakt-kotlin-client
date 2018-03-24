package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktShowStatus constructor(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("returning series")
    RETURNING_SERIES(1, "returning series", "returning series", "Returning Series"),
    @SerializedName("in production")
    IN_PRODUCTION(2, "in production", "in production", "In Production"),
    /* FIXME */@SerializedName("canceled")
    CANCELED(4, "canceled", "canceled", "Canceled"),
    @SerializedName("ended")
    ENDED(8, "ended", "ended", "Ended")
}
