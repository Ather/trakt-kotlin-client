package com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeasonWatchedProgress
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShowWatchedProgress
import java.time.ZonedDateTime

data class TraktShowWatchedProgressImpl(
        override var aired: Int? = null,
        override var completed: Int? = null,
        @SerializedName("hidden_seasons")
        override var hiddenSeasons: MutableList<TraktSeason> = mutableListOf(),
        @SerializedName("next_episode")
        override var nextEpisode: TraktEpisode = TraktEpisodeImpl(),
        @SerializedName("last_episode")
        override var lastEpisode: TraktEpisode = TraktEpisodeImpl(),

        @SerializedName("last_watched_at")
        override var lastWatchedAt: ZonedDateTime? = null,
        override var seasons: MutableList<TraktSeasonWatchedProgress> = mutableListOf()
) : TraktShowWatchedProgress
