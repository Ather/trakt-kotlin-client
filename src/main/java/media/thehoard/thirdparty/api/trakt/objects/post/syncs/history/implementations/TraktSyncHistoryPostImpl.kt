package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPost
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostEpisode
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostMovie
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostShow
import media.thehoard.thirdparty.api.trakt.utils.Json

data class TraktSyncHistoryPostImpl(
        override var movies: MutableList<TraktSyncHistoryPostMovie> = mutableListOf(),
        override var shows: MutableList<TraktSyncHistoryPostShow> = mutableListOf(),
        override var episodes: MutableList<TraktSyncHistoryPostEpisode> = mutableListOf()
) : TraktSyncHistoryPost {

    override fun toJson(): String = Json.serialize(this)

    companion object {
        fun builder(): TraktSyncHistoryPostBuilderImpl {
            return TraktSyncHistoryPostBuilderImpl()
        }
    }
}

