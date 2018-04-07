package media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import java.time.ZonedDateTime

data class TraktEpisodeImpl(
        override var season: Int = -1,
        override var number: Int = -1,
        override var title: String = "",
        override var ids: TraktEpisodeIdsImpl = TraktEpisodeIdsImpl(),
        @SerializedName("number_abs")
        override var numberAbsolute: Int? = null,
        override var overview: String? = null,
        @SerializedName("first_aired")
        override var firstAired: ZonedDateTime? = null,
        @SerializedName("updated_at")
        override var updatedAt: ZonedDateTime? = null,
        override var rating: Float? = null,
        override var votes: Int? = null,
        @SerializedName("comment_count")
        override var commentCount: Int? = null,
        @SerializedName("available_translations")
        override var availableTranslations: List<String>? = null,
        override var runtime: Int? = null
) : TraktEpisode
