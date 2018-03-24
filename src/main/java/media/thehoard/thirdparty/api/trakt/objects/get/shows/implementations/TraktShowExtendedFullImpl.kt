package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktShowStatus
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowExtendedFull
import java.time.Instant

data class TraktShowExtendedFullImpl(
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktShowIdsImpl = TraktShowIdsImpl(),
        override var overview: String = "",
        @SerializedName("first_aired")
        override var firstAired: Instant? = null,
        override var airs: TraktShowAirsImpl = TraktShowAirsImpl(),
        override var runtime: Int? = null,
        override var certification: String = "",
        override var network: String = "",
        override var country: String = "",
        @SerializedName("updated_at")
        override var updatedAt: Instant? = null,
        override var trailer: String = "",
        override var homepage: String = "",
        override var status: TraktShowStatus = TraktShowStatus.UNSPECIFIED,
        override var rating: Float? = null,
        override var votes: Int? = null,
        @SerializedName("comment_count")
        override var commentCount: Int? = null,
        override var language: String = "",
        @SerializedName("available_translations")
        override var availableTranslations: List<String> = listOf(),
        override var genres: List<String> = listOf(),
        @SerializedName("aired_episodes")
        override var airedEpisodes: Int? = null
) : TraktShowExtendedFull {
    constructor(traktShow: TraktShow) : this(traktShow.title, traktShow.year, traktShow.ids)
}
