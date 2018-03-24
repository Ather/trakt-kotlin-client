package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl

interface TraktMovieScrobblePost : TraktScrobblePost {
    var movie: TraktMovieImpl
}