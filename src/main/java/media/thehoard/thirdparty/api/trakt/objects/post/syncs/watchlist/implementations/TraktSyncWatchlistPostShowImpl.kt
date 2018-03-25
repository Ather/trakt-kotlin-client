package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostShow

data class TraktSyncWatchlistPostShowImpl(
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktShowIdsImpl = TraktShowIdsImpl(),
        override var seasons: MutableList<TraktSyncWatchlistPostShowSeasonImpl> = mutableListOf()
) : TraktSyncWatchlistPostShow
