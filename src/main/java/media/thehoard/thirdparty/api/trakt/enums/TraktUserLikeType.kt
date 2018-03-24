package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktUserLikeType constructor(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("comment")
    COMMENT(1, "comment", "comments", "Comment"),
    @SerializedName("list")
    LIST(2, "list", "list", "List")
}
