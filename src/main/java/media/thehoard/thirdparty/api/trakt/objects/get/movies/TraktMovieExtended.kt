package media.thehoard.thirdparty.api.trakt.objects.get.movies

import java.util.Date

interface TraktMovieExtended : TraktMovie {
    var tagline: String

    var overview: String

    var released: Date?

    var runtime: Int?

    var updatedAt: Date?

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
