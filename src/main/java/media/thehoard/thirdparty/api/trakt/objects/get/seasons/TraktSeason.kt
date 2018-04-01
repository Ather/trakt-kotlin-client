package media.thehoard.thirdparty.api.trakt.objects.get.seasons

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonIdsImpl
import java.time.Instant

interface TraktSeason {
    var number: Int?

    var ids: TraktSeasonIdsImpl

    var rating: Float?

    var votes: Int?

    var episodeCount: Int?

    var airedEpisodes: Int?

    var title: String

    var overview: String

    var firstAired: Instant?

    var network: String

    var episodes: MutableList<TraktEpisodeImpl>
}
