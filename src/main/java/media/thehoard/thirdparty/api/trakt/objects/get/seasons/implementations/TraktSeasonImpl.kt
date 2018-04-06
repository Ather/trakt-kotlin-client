package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import java.time.ZonedDateTime

data class TraktSeasonImpl(
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
        override var firstAired: ZonedDateTime? = null,
        override var network: String = "",
        override var episodes: MutableList<TraktEpisodeImpl> = mutableListOf()
) : TraktSeason
