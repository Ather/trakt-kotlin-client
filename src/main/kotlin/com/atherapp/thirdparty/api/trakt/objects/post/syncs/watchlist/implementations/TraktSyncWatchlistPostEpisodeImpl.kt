package com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktEpisodeIds
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostEpisode

data class TraktSyncWatchlistPostEpisodeImpl(
        override var ids: TraktEpisodeIds = TraktEpisodeIds()
) : TraktSyncWatchlistPostEpisode
