package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktListSortBy(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("rank")
    RANK(1, "rank", "rank", "Rank"),
    @SerializedName("added")
    ADDED(2, "added", "added", "Added"),
    @SerializedName("title")
    TITLE(4, "title", "title", "Title"),
    @SerializedName("released")
    RELEASED(8, "released", "released", "Released"),
    @SerializedName("runtime")
    RUNTIME(16, "runtime", "runtime", "Runtime"),
    @SerializedName("popularity")
    POPULARITY(32, "popularity", "popularity", "Popularity"),
    @SerializedName("percentage")
    PERCENTAGE(64, "percentage", "percentage", "Percentage"),
    @SerializedName("votes")
    VOTES(128, "votes", "votes", "Votes"),
    @SerializedName("my_rating")
    MY_RATING(256, "my_rating", "my_rating", "My Rating"),
    @SerializedName("random")
    RANDOM(512, "random", "random", "Random");

    override fun toString() = displayName
}