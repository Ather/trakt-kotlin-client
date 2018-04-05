package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.Instant

interface TraktRecentlyUpdatedMovie : TraktMovie {
    override var updatedAt: Instant?

    var movie: TraktMovieImpl

}
