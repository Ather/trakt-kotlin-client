package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl

interface TraktMostAnticipatedMovie : TraktMovie {
    var listCount: Int?

    var movie: TraktMovieImpl
}
