package com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovieIds

interface TraktSyncWatchlistPostMovie {
    var title: String
    var year: Int?
    var ids: TraktMovieIds
}