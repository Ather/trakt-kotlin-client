package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostShowSeason

data class TraktSyncWatchlistPostShowSeasonImpl(
        override var number: Int = 0,
        override var episodes: MutableList<TraktSyncWatchlistPostShowEpisodeImpl> = mutableListOf()
) : TraktSyncWatchlistPostShowSeason
