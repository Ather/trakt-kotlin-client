package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations.TraktSyncWatchlistPostShowSeasonImpl

interface TraktSyncWatchlistPostShow {
    var title: String
    var year: Int?
    var ids: TraktShowIdsImpl
    var seasons: MutableList<TraktSyncWatchlistPostShowSeasonImpl>
}