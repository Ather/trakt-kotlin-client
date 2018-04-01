package media.thehoard.thirdparty.api.trakt.objects.get.episodes

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import java.time.Instant

interface TraktEpisode {
    var season: Int?

    var number: Int?

    var title: String

    var ids: TraktEpisodeIdsImpl

    var numberAbsolute: Int?

    var overview: String

    var firstAired: Instant?

    var updatedAt: Instant?

    var rating: Float?

    var votes: Int?

    var commentCount: Int?

    var availableTranslations: List<String>

    var runtime: Int?
}
