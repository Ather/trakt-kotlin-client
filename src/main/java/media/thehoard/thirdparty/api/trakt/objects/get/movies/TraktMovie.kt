package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IValidatable
import java.time.LocalDate
import java.time.ZonedDateTime

interface TraktMovie : IValidatable {
    var title: String

    var year: Int

    var ids: TraktMovieIds

    var tagline: String?

    var overview: String?

    var released: LocalDate?

    var runtime: Int?

    var updatedAt: ZonedDateTime?

    var trailer: String?

    var homepage: String?

    var rating: Float?

    var votes: Int?

    var commentCount: Int?

    var language: String?

    var availableTranslations: List<String>?

    var genres: List<String>?

    var certification: String?
}
