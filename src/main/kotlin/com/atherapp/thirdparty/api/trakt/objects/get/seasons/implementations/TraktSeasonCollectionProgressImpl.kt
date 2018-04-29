package com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeCollectionProgress
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeasonCollectionProgress

class TraktSeasonCollectionProgressImpl(
        override var number: Int? = null,
        override var aired: Int? = null,
        override var completed: Int? = null,
        override var episodes: MutableList<TraktEpisodeCollectionProgress> = mutableListOf()
) : TraktSeasonCollectionProgress
