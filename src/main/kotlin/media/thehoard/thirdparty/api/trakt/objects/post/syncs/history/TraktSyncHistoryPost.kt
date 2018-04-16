package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history

import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktSyncHistoryPost : IRequestBody {
    var movies: MutableList<TraktSyncHistoryPostMovie>
    var shows: MutableList<TraktSyncHistoryPostShow>
    var episodes: MutableList<TraktSyncHistoryPostEpisode>

    override fun validate(variableName: String) = (movies.isNotEmpty() && shows.isNotEmpty() && episodes.isNotEmpty()).validate("no history items set", null)
}