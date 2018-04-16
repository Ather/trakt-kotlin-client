package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktMovieScrobblePost : TraktScrobblePost {
    var movie: TraktMovie
}