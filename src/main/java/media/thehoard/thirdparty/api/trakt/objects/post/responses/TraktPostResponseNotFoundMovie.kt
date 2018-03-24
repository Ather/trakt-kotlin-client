package media.thehoard.thirdparty.api.trakt.objects.post.responses

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl

interface TraktPostResponseNotFoundMovie {
    var ids: TraktMovieIdsImpl
}