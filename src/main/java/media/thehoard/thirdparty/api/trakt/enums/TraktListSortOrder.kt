package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktListSortOrder constructor(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("popular")
    POPULAR(1, "popular", "popular", "Popular"),
    @SerializedName("likes")
    LIKES(2, "likes", "likes", "Likes"),
    @SerializedName("comments")
    COMMENTS(4, "comments", "comments", "Comments"),
    @SerializedName("items")
    ITEMS(8, "items", "items", "Items"),
    @SerializedName("added")
    ADDED(16, "added", "added", "Added"),
    @SerializedName("updated")
    UPDATED(32, "updated", "updated", "Updated")
}
