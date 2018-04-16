package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktSyncRatingsPost : IRequestBody {
    var movies: MutableList<TraktSyncRatingsPostMovie>
    var shows: MutableList<TraktSyncRatingsPostShow>
    var episodes: MutableList<TraktSyncRatingsPostEpisode>
}