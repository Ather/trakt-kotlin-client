package com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostShowEpisode
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostShowSeason

data class TraktSyncWatchlistPostShowSeasonImpl(
        override var number: Int = 0,
        override var episodes: MutableList<TraktSyncWatchlistPostShowEpisode> = mutableListOf()
) : TraktSyncWatchlistPostShowSeason
