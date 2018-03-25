package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryRemovePost

class TraktSyncHistoryRemovePostImpl : TraktSyncHistoryRemovePost {
    override var movies: MutableList<TraktSyncHistoryPostMovieImpl>? = null
    override var shows: MutableList<TraktSyncHistoryPostShowImpl>? = null
    override var episodes: MutableList<TraktSyncHistoryPostEpisodeImpl>? = null
    override val ids: MutableList<Long>? = null

    companion object {
        fun builder(): TraktSyncHistoryRemovePostBuilder {
            return TraktSyncHistoryRemovePostBuilder()
        }
    }
}

