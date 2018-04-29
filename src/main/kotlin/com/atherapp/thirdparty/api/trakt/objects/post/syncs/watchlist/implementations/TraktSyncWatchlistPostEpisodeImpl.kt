package com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostEpisode

data class TraktSyncWatchlistPostEpisodeImpl(
        override var ids: TraktEpisodeIds = TraktEpisodeIdsImpl()
) : TraktSyncWatchlistPostEpisode
