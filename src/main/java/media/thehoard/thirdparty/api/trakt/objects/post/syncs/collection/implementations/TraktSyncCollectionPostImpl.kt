package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPost

data class TraktSyncCollectionPostImpl(
        override var movies: MutableList<TraktSyncCollectionPostMovieImpl> = mutableListOf(),
        override var shows: MutableList<TraktSyncCollectionPostShowImpl> = mutableListOf(),
        override var episodes: MutableList<TraktSyncCollectionPostEpisodeImpl> = mutableListOf()
) : TraktSyncCollectionPost {

    companion object {
        fun builder(): TraktSyncCollectionPostBuilderImpl = TraktSyncCollectionPostBuilderImpl()
    }
}
