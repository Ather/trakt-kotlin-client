package media.thehoard.thirdparty.api.trakt.objects.get.watched

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.ZonedDateTime

interface TraktWatchedMovie {
    var plays: Int?

    var lastWatchedAt: ZonedDateTime?

    var movie: TraktMovieImpl

}
