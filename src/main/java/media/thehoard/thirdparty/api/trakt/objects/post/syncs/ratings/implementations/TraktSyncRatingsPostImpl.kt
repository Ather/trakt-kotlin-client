package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPost

data class TraktSyncRatingsPostImpl(
        override var movies: MutableList<TraktSyncRatingsPostMovieImpl> = mutableListOf(),
        override var shows: MutableList<TraktSyncRatingsPostShowImpl> = mutableListOf(),
        override var episodes: MutableList<TraktSyncRatingsPostEpisodeImpl> = mutableListOf()
) : TraktSyncRatingsPost {

    companion object {
        fun builder(): TraktSyncRatingsPostBuilder {
            return TraktSyncRatingsPostBuilder()
        }
    }
}