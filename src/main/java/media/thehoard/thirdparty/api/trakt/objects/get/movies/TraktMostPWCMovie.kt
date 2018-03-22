package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl

interface TraktMostPWCMovie : TraktMovie {

    var watcherCount: Int?

    var playCount: Int?

    var collectedCount: Int?

    var movie: TraktMovieImpl
}
