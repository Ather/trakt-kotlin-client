package com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeWatchedProgress
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeasonWatchedProgress

data class TraktSeasonWatchedProgressImpl(
        override var number: Int? = null,
        override var aired: Int? = null,
        override var completed: Int? = null,
        override var episodes: MutableList<TraktEpisodeWatchedProgress> = mutableListOf()
) : TraktSeasonWatchedProgress
