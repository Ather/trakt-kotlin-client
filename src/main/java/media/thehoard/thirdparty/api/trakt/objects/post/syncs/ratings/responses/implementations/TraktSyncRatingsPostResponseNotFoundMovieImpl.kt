package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsPostResponseNotFoundMovie

data class TraktSyncRatingsPostResponseNotFoundMovieImpl(
        override var rating: Int? = null,
        override var ids: TraktMovieIdsImpl = TraktMovieIdsImpl()
) : TraktSyncRatingsPostResponseNotFoundMovie
