package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations.TraktSyncHistoryPostEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations.TraktSyncHistoryPostMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations.TraktSyncHistoryPostShowImpl
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktSyncHistoryPost : IRequestBody {
    var movies: MutableList<TraktSyncHistoryPostMovieImpl>
    var shows: MutableList<TraktSyncHistoryPostShowImpl>
    var episodes: MutableList<TraktSyncHistoryPostEpisodeImpl>
}