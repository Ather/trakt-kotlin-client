package media.thehoard.thirdparty.api.trakt.objects.post.checkins

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl

interface TraktMovieCheckinPost : TraktCheckinPost {
    var movie: TraktMovieImpl
}
