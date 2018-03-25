package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPost

class TraktSyncHistoryPostImpl : TraktSyncHistoryPost {
    override var movies: MutableList<TraktSyncHistoryPostMovieImpl> = mutableListOf()

    override var shows: MutableList<TraktSyncHistoryPostShowImpl> = mutableListOf()

    override var episodes: MutableList<TraktSyncHistoryPostEpisodeImpl> = mutableListOf()

    companion object {
        fun builder(): TraktSyncHistoryPostBuilderImpl {
            return TraktSyncHistoryPostBuilderImpl()
        }
    }
}

