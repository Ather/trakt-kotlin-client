package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import java.time.ZonedDateTime

interface TraktMovie {
    var title: String

    var year: Int

    var ids: TraktMovieIdsImpl

    var tagline: String?

    var overview: String?

    var released: ZonedDateTime?

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
