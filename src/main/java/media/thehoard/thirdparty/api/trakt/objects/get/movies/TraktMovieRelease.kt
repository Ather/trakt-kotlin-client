package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.enums.TraktReleaseType
import java.time.Instant

import java.util.Date

interface TraktMovieRelease {
    var country: String

    var certification: String

    var releaseDate: Instant?

    var releaseType: TraktReleaseType

    var note: String

}
