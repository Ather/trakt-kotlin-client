package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryRemovePost
import media.thehoard.thirdparty.api.trakt.utils.Json

data class TraktSyncHistoryRemovePostImpl(
        override var movies: MutableList<TraktSyncHistoryPostMovieImpl> = mutableListOf(),
        override var shows: MutableList<TraktSyncHistoryPostShowImpl> = mutableListOf(),
        override var episodes: MutableList<TraktSyncHistoryPostEpisodeImpl> = mutableListOf(),
        override val ids: MutableList<Long> = mutableListOf()
) : TraktSyncHistoryRemovePost {
    override fun toJson(): String = Json.serialize(this)

    override fun validate() {}

    companion object {
        fun builder(): TraktSyncHistoryRemovePostBuilder {
            return TraktSyncHistoryRemovePostBuilder()
        }
    }
}

