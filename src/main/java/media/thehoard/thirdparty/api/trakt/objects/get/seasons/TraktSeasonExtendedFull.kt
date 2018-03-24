package media.thehoard.thirdparty.api.trakt.objects.get.seasons

import java.time.Instant

interface TraktSeasonExtendedFull : TraktSeason {
    var rating: Float?

    var votes: Int?

    var episodeCount: Int?

    var airedEpisodes: Int?

    var title: String

    var overview: String

    var firstAired: Instant?

    var network: String
}
