package com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist

import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktSyncWatchlistPost : IRequestBody {
    var movies: MutableList<TraktSyncWatchlistPostMovie>
    var shows: MutableList<TraktSyncWatchlistPostShow>
    var episodes: MutableList<TraktSyncWatchlistPostEpisode>
}