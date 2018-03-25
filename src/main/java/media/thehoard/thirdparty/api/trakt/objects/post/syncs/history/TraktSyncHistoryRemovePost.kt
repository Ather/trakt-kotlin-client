package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations.TraktSyncHistoryPostEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations.TraktSyncHistoryPostMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations.TraktSyncHistoryPostShowImpl

interface TraktSyncHistoryRemovePost {
    var movies: MutableList<TraktSyncHistoryPostMovieImpl>?
    var shows: MutableList<TraktSyncHistoryPostShowImpl>?
    var episodes: MutableList<TraktSyncHistoryPostEpisodeImpl>?
    val ids: MutableList<Long>?
}