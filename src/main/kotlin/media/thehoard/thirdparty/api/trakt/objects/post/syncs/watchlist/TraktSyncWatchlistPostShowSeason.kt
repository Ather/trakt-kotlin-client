package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist

interface TraktSyncWatchlistPostShowSeason {
    var number: Int
    var episodes: MutableList<TraktSyncWatchlistPostShowEpisode>
}