package media.thehoard.thirdparty.api.trakt.objects.post.responses

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds

interface TraktPostResponseNotFoundMovie {
    var ids: TraktMovieIds
}