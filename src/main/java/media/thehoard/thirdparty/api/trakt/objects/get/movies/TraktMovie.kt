package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl

interface TraktMovie {
    var title: String

    var year: Int?

    var ids: TraktMovieIdsImpl
}
