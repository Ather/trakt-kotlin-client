package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import java.time.ZonedDateTime

data class TraktMovieImpl(
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktMovieIdsImpl = TraktMovieIdsImpl(),
        override var tagline: String = "",
        override var overview: String = "",
        override var released: ZonedDateTime? = null,
        override var runtime: Int? = null,
        @SerializedName("updated_at")
        override var updatedAt: ZonedDateTime? = null,
        override var trailer: String = "",
        override var homepage: String = "",
        override var rating: Float? = null,
        override var votes: Int? = null,
        @SerializedName("comment_count")
        override var commentCount: Int? = null,
        override var language: String = "",
        @SerializedName("available_translations")
        override var availableTranslations: List<String> = listOf(),
        override var genres: List<String> = listOf(),
        override var certification: String = ""
) : TraktMovie
