package media.thehoard.thirdparty.api.trakt.objects.get.watched

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl

import java.time.Instant

interface TraktWatchedMovie {
    var plays: Int?

    var lastWatchedAt: Instant?

    var movie: TraktMovieImpl

}
