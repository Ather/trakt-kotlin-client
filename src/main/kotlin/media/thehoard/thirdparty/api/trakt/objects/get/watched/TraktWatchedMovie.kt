package media.thehoard.thirdparty.api.trakt.objects.get.watched

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import java.time.ZonedDateTime

interface TraktWatchedMovie {
    var plays: Int?

    var lastWatchedAt: ZonedDateTime?

    var movie: TraktMovie

}
