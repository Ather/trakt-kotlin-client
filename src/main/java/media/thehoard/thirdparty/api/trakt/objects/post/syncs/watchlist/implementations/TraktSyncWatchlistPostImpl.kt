package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPost
import media.thehoard.thirdparty.api.trakt.utils.Json

data class TraktSyncWatchlistPostImpl(
        override var movies: MutableList<TraktSyncWatchlistPostMovieImpl> = mutableListOf(),
        override var shows: MutableList<TraktSyncWatchlistPostShowImpl> = mutableListOf(),
        override var episodes: MutableList<TraktSyncWatchlistPostEpisodeImpl> = mutableListOf()
) : TraktSyncWatchlistPost {

    override fun toJson(): String = Json.serialize(this)

    override fun validate(variableName: String) = (movies.isNotEmpty() && shows.isNotEmpty() && episodes.isNotEmpty()).validate("no watchlist items set", null)

    companion object {

        fun builder(): TraktSyncWatchlistPostBuilderImpl {
            return TraktSyncWatchlistPostBuilderImpl()
        }
    }
}