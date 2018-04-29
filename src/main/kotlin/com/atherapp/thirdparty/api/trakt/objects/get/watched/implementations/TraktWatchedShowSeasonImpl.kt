package com.atherapp.thirdparty.api.trakt.objects.get.watched.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.watched.TraktWatchedShowEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.watched.TraktWatchedShowSeason

data class TraktWatchedShowSeasonImpl(
        override var number: Int? = null,
        override var episodes: MutableList<TraktWatchedShowEpisode> = mutableListOf()
) : TraktWatchedShowSeason