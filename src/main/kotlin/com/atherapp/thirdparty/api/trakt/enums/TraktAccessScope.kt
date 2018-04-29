package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktAccessScope(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("public")
    PUBLIC(1, "public", "public", "Public"),
    @SerializedName("private")
    PRIVATE(2, "private", "private", "Private"),
    @SerializedName("friends")
    FRIENDS(4, "friends", "friends", "Friends");

    override fun toString() = displayName
}
