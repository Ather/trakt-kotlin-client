package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.enums.TraktShowStatus
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IValidatable
import java.time.ZonedDateTime

interface TraktShow : IValidatable {
    var title: String

    var year: Int

    var ids: TraktShowIds

    var overview: String?

    var firstAired: ZonedDateTime?

    var airs: TraktShowAirs?

    var runtime: Int?

    var certification: String?

    var network: String?

    var country: String?

    var updatedAt: ZonedDateTime?

    var trailer: String?

    var homepage: String?

    var status: TraktShowStatus?

    var rating: Float?

    var votes: Int?

    var commentCount: Int?

    var language: String?

    var availableTranslations: List<String>?

    var genres: List<String>?

    var airedEpisodes: Int?

    fun validateWithEpisode(episode: TraktEpisode? = null)
}
