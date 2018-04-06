package media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.ZonedDateTime

data class TraktCalendarMovieImpl(
        override var released: ZonedDateTime? = null,
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktCalendarMovie, TraktMovie by movie
