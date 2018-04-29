package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktHiddenItemType(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIIED,
    @SerializedName("movie")
    MOVIE(1, "movie", "movie", "Movie"),
    @SerializedName("show")
    SHOW(2, "show", "show", "Show"),
    @SerializedName("season")
    SEASON(4, "season", "season", "Season");

    override fun toString() = displayName
}
