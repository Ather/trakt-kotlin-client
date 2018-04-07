package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPost
import media.thehoard.thirdparty.api.trakt.utils.Json

data class TraktSyncRatingsPostImpl(
        override var movies: MutableList<TraktSyncRatingsPostMovieImpl> = mutableListOf(),
        override var shows: MutableList<TraktSyncRatingsPostShowImpl> = mutableListOf(),
        override var episodes: MutableList<TraktSyncRatingsPostEpisodeImpl> = mutableListOf()
) : TraktSyncRatingsPost {
    override fun toJson(): String = Json.serialize(this)

    override fun validate() {}

    companion object {
        fun builder(): TraktSyncRatingsPostBuilder {
            return TraktSyncRatingsPostBuilder()
        }
    }
}