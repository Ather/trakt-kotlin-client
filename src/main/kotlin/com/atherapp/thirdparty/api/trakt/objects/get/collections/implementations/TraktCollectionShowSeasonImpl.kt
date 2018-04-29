package com.atherapp.thirdparty.api.trakt.objects.get.collections.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowSeason

data class TraktCollectionShowSeasonImpl(
        override var number: Int? = null,
        override var episodes: MutableList<TraktCollectionShowEpisode> = mutableListOf()
) : TraktCollectionShowSeason
