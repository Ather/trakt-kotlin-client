package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.enums.TraktShowStatus
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowAirsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import java.time.Instant

interface TraktShow {
    var title: String

    var year: Int?

    var ids: TraktShowIdsImpl

    var overview: String

    var firstAired: Instant?

    var airs: TraktShowAirsImpl

    var runtime: Int?

    var certification: String

    var network: String

    var country: String

    var updatedAt: Instant?

    var trailer: String

    var homepage: String

    var status: TraktShowStatus

    var rating: Float?

    var votes: Int?

    var commentCount: Int?

    var language: String

    var availableTranslations: List<String>

    var genres: List<String>

    var airedEpisodes: Int?
}
