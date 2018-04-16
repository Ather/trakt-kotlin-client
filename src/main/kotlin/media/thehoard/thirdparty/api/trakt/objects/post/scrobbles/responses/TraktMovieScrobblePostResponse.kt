package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktMovieScrobblePostResponse : TraktScrobblePostResponse {
    var movie: TraktMovie
}