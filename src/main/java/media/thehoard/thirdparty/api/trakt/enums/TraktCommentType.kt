package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktCommentType constructor(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("reviews")
    REVIEW(1, "reviews", "reviews", "Review"),
    @SerializedName("shouts")
    SHOUT(2, "shouts", "shouts", "Shout"),
    @SerializedName("all")
    ALL(4, "all", "all", "All")
}
