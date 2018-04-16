package media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.LocalDate

data class TraktCalendarMovieImpl(
        @SerializedName("released")
        override var calendarRelease: LocalDate? = null,
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktCalendarMovie, TraktMovie by movie
