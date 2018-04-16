package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostShowEpisode

data class TraktSyncWatchlistPostShowEpisodeImpl(
        override var number: Int = 0
) : TraktSyncWatchlistPostShowEpisode
