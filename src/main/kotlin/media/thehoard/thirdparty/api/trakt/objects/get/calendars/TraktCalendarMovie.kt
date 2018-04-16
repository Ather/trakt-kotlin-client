package media.thehoard.thirdparty.api.trakt.objects.get.calendars

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import java.time.LocalDate

interface TraktCalendarMovie : TraktMovie {
    var calendarRelease: LocalDate?

    var movie: TraktMovie

}
