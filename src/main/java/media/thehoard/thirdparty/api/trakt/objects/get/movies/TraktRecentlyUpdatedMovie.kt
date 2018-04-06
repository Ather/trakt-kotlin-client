package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.ZonedDateTime

interface TraktRecentlyUpdatedMovie : TraktMovie {
    override var updatedAt: ZonedDateTime?

    var movie: TraktMovieImpl

}
