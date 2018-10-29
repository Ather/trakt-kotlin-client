package com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktMovieIds
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostMovie

data class TraktSyncWatchlistPostMovieImpl(
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktMovieIds = TraktMovieIds()
) : TraktSyncWatchlistPostMovie
