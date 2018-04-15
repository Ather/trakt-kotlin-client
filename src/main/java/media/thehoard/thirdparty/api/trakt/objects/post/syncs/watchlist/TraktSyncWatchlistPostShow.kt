package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowIds

interface TraktSyncWatchlistPostShow {
    var title: String
    var year: Int?
    var ids: TraktShowIds
    var seasons: MutableList<TraktSyncWatchlistPostShowSeason>
}