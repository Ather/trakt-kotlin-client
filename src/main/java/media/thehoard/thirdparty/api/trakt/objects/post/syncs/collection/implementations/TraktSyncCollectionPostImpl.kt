package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPost
import media.thehoard.thirdparty.api.trakt.utils.Json

data class TraktSyncCollectionPostImpl(
        override var movies: MutableList<TraktSyncCollectionPostMovieImpl> = mutableListOf(),
        override var shows: MutableList<TraktSyncCollectionPostShowImpl> = mutableListOf(),
        override var episodes: MutableList<TraktSyncCollectionPostEpisodeImpl> = mutableListOf()
) : TraktSyncCollectionPost {

    companion object {
        fun builder(): TraktSyncCollectionPostBuilderImpl = TraktSyncCollectionPostBuilderImpl()
    }

    override fun toJson(): String = Json.gson.toJson(this)

    override fun validate() {}
}
