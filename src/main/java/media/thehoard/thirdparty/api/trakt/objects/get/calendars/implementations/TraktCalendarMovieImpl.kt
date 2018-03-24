package media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.Instant

data class TraktCalendarMovieImpl(
        override var released: Instant? = null,
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktCalendarMovie {

    override var title: String
        get() = movie.title
        set(title) {
            movie.title = title
        }
    override var year: Int?
        get() = movie.year
        set(year) {
            movie.year = year
        }
    override var ids: TraktMovieIdsImpl
        get() = movie.ids
        set(ids) {
            movie.ids = ids
        }
}
