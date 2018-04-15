package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPost
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostEpisode
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostMovie
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostShow
import media.thehoard.thirdparty.api.trakt.utils.Json

data class TraktSyncWatchlistPostImpl(
        override var movies: MutableList<TraktSyncWatchlistPostMovie> = mutableListOf(),
        override var shows: MutableList<TraktSyncWatchlistPostShow> = mutableListOf(),
        override var episodes: MutableList<TraktSyncWatchlistPostEpisode> = mutableListOf()
) : TraktSyncWatchlistPost {

    override fun toJson(): String = Json.serialize(this)

    override fun validate(variableName: String) = (movies.isNotEmpty() && shows.isNotEmpty() && episodes.isNotEmpty()).validate("no watchlist items set", null)

    companion object {

        fun builder(): TraktSyncWatchlistPostBuilderImpl {
            return TraktSyncWatchlistPostBuilderImpl()
        }
    }
}