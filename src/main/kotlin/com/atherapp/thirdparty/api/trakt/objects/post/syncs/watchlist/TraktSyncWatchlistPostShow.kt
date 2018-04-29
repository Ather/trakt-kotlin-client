package com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist

import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShowIds

interface TraktSyncWatchlistPostShow {
    var title: String
    var year: Int?
    var ids: TraktShowIds
    var seasons: MutableList<TraktSyncWatchlistPostShowSeason>
}