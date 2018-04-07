package media.thehoard.thirdparty.api.trakt.objects.get.episodes

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import java.time.ZonedDateTime

interface TraktEpisode {
    var season: Int

    var number: Int

    var title: String

    var ids: TraktEpisodeIdsImpl

    var numberAbsolute: Int?

    var overview: String?

    var firstAired: ZonedDateTime?

    var updatedAt: ZonedDateTime?

    var rating: Float?

    var votes: Int?

    var commentCount: Int?

    var availableTranslations: List<String>?

    var runtime: Int?
}
