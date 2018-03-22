package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl

interface TraktBoxOfficeMovie : TraktMovie {
    var revenue: Long?

    var movie: TraktMovieImpl
}
