package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPost

data class TraktSyncWatchlistPostImpl(
        override var movies: MutableList<TraktSyncWatchlistPostMovieImpl> = mutableListOf(),
        override var shows: MutableList<TraktSyncWatchlistPostShowImpl> = mutableListOf(),
        override var episodes: MutableList<TraktSyncWatchlistPostEpisodeImpl> = mutableListOf()
) : TraktSyncWatchlistPost {

    companion object {

        fun builder(): TraktSyncWatchlistPostBuilderImpl {
            return TraktSyncWatchlistPostBuilderImpl()
        }
    }
}