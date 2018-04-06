package media.thehoard.thirdparty.api.trakt.objects.get.collections

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.ZonedDateTime

interface TraktCollectionMovie : TraktMovie {
    var collectedAt: ZonedDateTime?

    var movie: TraktMovieImpl
}