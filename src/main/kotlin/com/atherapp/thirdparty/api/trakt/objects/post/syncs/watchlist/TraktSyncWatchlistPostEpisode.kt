package com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds

interface TraktSyncWatchlistPostEpisode {
    var ids: TraktEpisodeIds
}