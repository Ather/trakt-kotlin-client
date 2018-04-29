package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktListSortHow(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("asc")
    ASCENDING(1, "asc", "asc", "Ascending"),
    @SerializedName("desc")
    DESCENDING(1, "desc", "desc", "Descending");

    override fun toString() = displayName
}