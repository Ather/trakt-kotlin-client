package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostMovie

data class TraktSyncWatchlistPostMovieImpl(
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktMovieIds = TraktMovieIdsImpl()
) : TraktSyncWatchlistPostMovie
