package media.thehoard.thirdparty.api.trakt.objects.get.calendars

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.ZonedDateTime

interface TraktCalendarMovie : TraktMovie {
    override var released: ZonedDateTime?

    var movie: TraktMovieImpl

}
