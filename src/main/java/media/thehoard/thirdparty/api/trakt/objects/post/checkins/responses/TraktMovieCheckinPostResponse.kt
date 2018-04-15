package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktMovieCheckinPostResponse : TraktCheckinPostResponse {
    var movie: TraktMovie

}
