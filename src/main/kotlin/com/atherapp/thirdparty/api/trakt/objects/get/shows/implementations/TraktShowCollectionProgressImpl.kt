package com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeasonCollectionProgress
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShowCollectionProgress
import java.time.ZonedDateTime

data class TraktShowCollectionProgressImpl(
        override var lastCollectedAt: ZonedDateTime? = null,
        override var seasons: MutableList<TraktSeasonCollectionProgress> = mutableListOf(),
        override var aired: Int? = null,
        override var completed: Int? = null,
        override var hiddenSeasons: MutableList<TraktSeason> = mutableListOf(),
        override var nextEpisode: TraktEpisode = TraktEpisodeImpl(),
        override var lastEpisode: TraktEpisode = TraktEpisodeImpl()
) : TraktShowCollectionProgress