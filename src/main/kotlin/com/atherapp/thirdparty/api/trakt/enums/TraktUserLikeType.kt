package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktUserLikeType(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("comment")
    COMMENT(1, "comment", "comments", "Comment"),
    @SerializedName("list")
    LIST(2, "list", "list", "List");

    override fun toString() = displayName
}
