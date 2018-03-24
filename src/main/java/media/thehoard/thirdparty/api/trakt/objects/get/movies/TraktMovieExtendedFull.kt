package media.thehoard.thirdparty.api.trakt.objects.get.movies

import java.time.Instant
import java.util.Date

interface TraktMovieExtendedFull : TraktMovie {
    var tagline: String

    var overview: String

    var released: Instant?

    var runtime: Int?

    var updatedAt: Instant?

    var trailer: String

    var homepage: String

    var rating: Float?

    var votes: Int?

    var commentCount: Int?

    var language: String

    var availableTranslations: List<String>

    var genres: List<String>

    var certification: String
}
