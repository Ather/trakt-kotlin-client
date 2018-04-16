package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktCommentType(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("reviews")
    REVIEW(1, "reviews", "reviews", "Review"),
    @SerializedName("shouts")
    SHOUT(2, "shouts", "shouts", "Shout"),
    @SerializedName("all")
    ALL(4, "all", "all", "All");

    override fun toString() = displayName
}
