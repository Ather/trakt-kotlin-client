package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl

interface TraktMovieCheckinPostResponse : TraktCheckinPostResponse {
    var movie: TraktMovieImpl

}
