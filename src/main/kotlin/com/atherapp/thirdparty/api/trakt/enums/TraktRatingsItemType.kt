package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktRatingsItemType(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("movie")
    MOVIE(1, "movie", "movies", "Movie"),
    @SerializedName("show")
    SHOW(2, "show", "shows", "Show"),
    @SerializedName("season")
    SEASON(4, "season", "seasons", "Season"),
    @SerializedName("episode")
    EPISODE(8, "episode", "episodes", "Episode"),
    @SerializedName("all")
    ALL(16, "all", "all", "All");

    override fun toString() = displayName
}
