package media.thehoard.thirdparty.api.trakt.objects.get.seasons

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonIdsImpl
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IValidatable
import java.time.ZonedDateTime

interface TraktSeason : IValidatable {
    var number: Int

    var ids: TraktSeasonIdsImpl

    var rating: Float?

    var votes: Int?

    var episodeCount: Int?

    var airedEpisodes: Int?

    var title: String?

    var overview: String?

    var firstAired: ZonedDateTime?

    var network: String?

    var episodes: MutableList<TraktEpisodeImpl>?
}
