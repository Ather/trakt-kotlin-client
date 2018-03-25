package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostEpisode

data class TraktSyncWatchlistPostEpisodeImpl(
        override var ids: TraktEpisodeIdsImpl = TraktEpisodeIdsImpl()
) : TraktSyncWatchlistPostEpisode
