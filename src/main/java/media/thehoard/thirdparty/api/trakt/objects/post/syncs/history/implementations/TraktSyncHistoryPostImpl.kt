package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPost
import media.thehoard.thirdparty.api.trakt.utils.Json

data class TraktSyncHistoryPostImpl(
        override var movies: MutableList<TraktSyncHistoryPostMovieImpl> = mutableListOf(),
        override var shows: MutableList<TraktSyncHistoryPostShowImpl> = mutableListOf(),
        override var episodes: MutableList<TraktSyncHistoryPostEpisodeImpl> = mutableListOf()
) : TraktSyncHistoryPost {

    override fun toJson(): String = Json.gson.toJson(this)

    override fun validate() {}

    companion object {
        fun builder(): TraktSyncHistoryPostBuilderImpl {
            return TraktSyncHistoryPostBuilderImpl()
        }
    }
}

