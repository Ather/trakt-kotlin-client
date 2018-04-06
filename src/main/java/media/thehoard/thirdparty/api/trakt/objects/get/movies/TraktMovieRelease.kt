package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.enums.TraktReleaseType
import java.time.ZonedDateTime

interface TraktMovieRelease {
    var country: String

    var certification: String

    var releaseDate: ZonedDateTime?

    var releaseType: TraktReleaseType

    var note: String

}
