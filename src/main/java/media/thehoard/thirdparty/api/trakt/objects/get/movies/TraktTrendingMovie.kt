package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl

interface TraktTrendingMovie : TraktMovie {
    var watchers: Int?

    var movie: TraktMovieImpl

}
