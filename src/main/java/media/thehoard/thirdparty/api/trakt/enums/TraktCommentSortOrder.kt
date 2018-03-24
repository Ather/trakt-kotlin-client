package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktCommentSortOrder(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("newest")
    NEWEST(1, "newest", "newest", "Newest"),
    @SerializedName("oldest")
    OLDEST(2, "oldest", "oldest", "Oldest"),
    @SerializedName("likes")
    LIKES(4, "likes", "likes", "Likes"),
    @SerializedName("replies")
    REPLIES(8, "replies", "replies", "Replies")
}
