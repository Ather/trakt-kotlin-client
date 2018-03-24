package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonExtendedFull
import java.time.Instant

data class TraktSeasonExtendedFullImpl(
        override var number: Int? = null,
        override var ids: TraktSeasonIdsImpl = TraktSeasonIdsImpl(),
        override var rating: Float? = null,
        override var votes: Int? = null,
        @SerializedName("episode_count")
        override var episodeCount: Int? = null,
        @SerializedName("aired_episodes")
        override var airedEpisodes: Int? = null,
        override var title: String = "",
        override var overview: String = "",
        @SerializedName("first_aired")
        override var firstAired: Instant? = null,
        override var network: String = ""
) : TraktSeasonExtendedFull {
    constructor(traktSeason: TraktSeason) : this(traktSeason.number, traktSeason.ids)
}
