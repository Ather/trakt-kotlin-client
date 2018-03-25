package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl

interface TraktSyncRatingsPostResponseNotFoundMovie {
    var rating: Int?
    var ids: TraktMovieIdsImpl
}