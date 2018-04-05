package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktTrendingMovie

data class TraktTrendingMovieImpl(
        override var watchers: Int? = null,
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktTrendingMovie, TraktMovie by movie
