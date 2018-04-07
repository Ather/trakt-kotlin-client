package media.thehoard.thirdparty.api.trakt.objects.get.calendars

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.ZonedDateTime

interface TraktCalendarMovie : TraktMovie {
    var calendarRelease: ZonedDateTime?

    var movie: TraktMovieImpl

}
