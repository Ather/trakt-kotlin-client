package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktCommentSortOrder(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("newest")
    NEWEST(1, "newest", "newest", "Newest"),
    @SerializedName("oldest")
    OLDEST(2, "oldest", "oldest", "Oldest"),
    @SerializedName("likes")
    LIKES(4, "likes", "likes", "Likes"),
    @SerializedName("replies")
    REPLIES(8, "replies", "replies", "Replies");

    override fun toString() = displayName
}
