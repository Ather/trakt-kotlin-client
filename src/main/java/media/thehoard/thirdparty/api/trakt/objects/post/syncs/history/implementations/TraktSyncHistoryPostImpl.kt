package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPost

data class TraktSyncHistoryPostImpl(
        override var movies: MutableList<TraktSyncHistoryPostMovieImpl> = mutableListOf(),
        override var shows: MutableList<TraktSyncHistoryPostShowImpl> = mutableListOf(),
        override var episodes: MutableList<TraktSyncHistoryPostEpisodeImpl> = mutableListOf()
) : TraktSyncHistoryPost {

    companion object {
        fun builder(): TraktSyncHistoryPostBuilderImpl {
            return TraktSyncHistoryPostBuilderImpl()
        }
    }
}

