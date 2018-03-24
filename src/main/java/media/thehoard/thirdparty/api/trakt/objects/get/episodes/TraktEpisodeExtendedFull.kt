package media.thehoard.thirdparty.api.trakt.objects.get.episodes

import java.time.Instant

interface TraktEpisodeExtendedFull : TraktEpisode {
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
