package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations.TraktSyncWatchlistPostShowEpisodeImpl

interface TraktSyncWatchlistPostShowSeason {
    var number: Int
    var episodes: MutableList<TraktSyncWatchlistPostShowEpisodeImpl>
}