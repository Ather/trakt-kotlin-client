package com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShowIds
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostShow
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostShowSeason

data class TraktSyncWatchlistPostShowImpl(
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktShowIds = TraktShowIdsImpl(),
        override var seasons: MutableList<TraktSyncWatchlistPostShowSeason> = mutableListOf()
) : TraktSyncWatchlistPostShow
