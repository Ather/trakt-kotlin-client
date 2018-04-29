package com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostShowEpisode

data class TraktSyncWatchlistPostShowEpisodeImpl(
        override var number: Int = 0
) : TraktSyncWatchlistPostShowEpisode
