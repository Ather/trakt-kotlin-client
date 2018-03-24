package media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundMovie

data class TraktPostResponseNotFoundMovieImpl(
        override var ids: TraktMovieIdsImpl = TraktMovieIdsImpl()
) : TraktPostResponseNotFoundMovie
