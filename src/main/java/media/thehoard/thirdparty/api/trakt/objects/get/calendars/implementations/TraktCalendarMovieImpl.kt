package media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.ZonedDateTime

data class TraktCalendarMovieImpl(
        @SerializedName("released")
        override var calendarRelease: ZonedDateTime? = ZonedDateTime.now(),
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktCalendarMovie, TraktMovie by movie
