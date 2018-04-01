package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations.TraktSyncRatingsPostEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations.TraktSyncRatingsPostMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations.TraktSyncRatingsPostShowImpl
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktSyncRatingsPost : IRequestBody {
    var movies: MutableList<TraktSyncRatingsPostMovieImpl>
    var shows: MutableList<TraktSyncRatingsPostShowImpl>
    var episodes: MutableList<TraktSyncRatingsPostEpisodeImpl>
}