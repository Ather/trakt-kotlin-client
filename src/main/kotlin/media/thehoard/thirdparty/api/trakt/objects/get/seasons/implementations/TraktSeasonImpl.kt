package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonIds
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IValidatable
import java.time.ZonedDateTime

data class TraktSeasonImpl(
        override var number: Int = -1,
        override var ids: TraktSeasonIds = TraktSeasonIdsImpl(),
        override var rating: Float? = null,
        override var votes: Int? = null,
        @SerializedName("episode_count")
        override var episodeCount: Int? = null,
        @SerializedName("aired_episodes")
        override var airedEpisodes: Int? = null,
        override var title: String? = null,
        override var overview: String? = null,
        @SerializedName("first_aired")
        override var firstAired: ZonedDateTime? = null,
        override var network: String? = null,
        override var episodes: MutableList<TraktEpisode>? = null
) : TraktSeason, IValidatable by ids
