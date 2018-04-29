package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktSearchIdType(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("trakt")
    TRAKT(1, "trakt", "trakt", "Trakt"),
    @SerializedName("imdb")
    IMDB(2, "imdb", "imdb", "Internet Movie Database"),
    @SerializedName("tmdb")
    TMDB(4, "tmdb", "tmdb", "The Movie Database"),
    @SerializedName("tvdb")
    TVDB(8, "tvdb", "tvdb", "TheTVDB");

    override fun toString() = displayName
}
