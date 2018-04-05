package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktBoxOfficeMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie

data class TraktBoxOfficeMovieImpl(
        override var revenue: Long? = null,
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktBoxOfficeMovie, TraktMovie by movie