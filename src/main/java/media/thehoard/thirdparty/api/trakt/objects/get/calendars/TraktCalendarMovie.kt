package media.thehoard.thirdparty.api.trakt.objects.get.calendars

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl

import java.time.Instant
import java.util.Date

interface TraktCalendarMovie : TraktMovie {
    var released: Instant?

    var movie: TraktMovieImpl

}
