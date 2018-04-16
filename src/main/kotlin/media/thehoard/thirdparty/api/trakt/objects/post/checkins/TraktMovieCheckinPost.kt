package media.thehoard.thirdparty.api.trakt.objects.post.checkins

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktMovieCheckinPost : TraktCheckinPost {
    var movie: TraktMovie
}
