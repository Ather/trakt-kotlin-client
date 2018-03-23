package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.Instant

import java.util.Date

interface TraktRecentlyUpdatedMovie : TraktMovie {
    var updatedAt: Instant?

    var movie: TraktMovieImpl

}
