package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.extensions.isValidYear
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import java.time.ZonedDateTime

data class TraktMovieImpl(
        override var title: String = "",
        override var year: Int = -1,
        override var ids: TraktMovieIdsImpl = TraktMovieIdsImpl(),
        override var tagline: String? = null,
        override var overview: String? = null,
        override var released: ZonedDateTime? = null,
        override var runtime: Int? = null,
        @SerializedName("updated_at")
        override var updatedAt: ZonedDateTime? = null,
        override var trailer: String? = null,
        override var homepage: String? = null,
        override var rating: Float? = null,
        override var votes: Int? = null,
        @SerializedName("comment_count")
        override var commentCount: Int? = null,
        override var language: String? = null,
        @SerializedName("available_translations")
        override var availableTranslations: List<String>? = null,
        override var genres: List<String>? = null,
        override var certification: String? = null
) : TraktMovie {
    override fun validate(variableName: String) {
        title.validate("movie title", String::isNotBlank)
        year.validate("movie year", ::isValidYear)
        ids.validate("movie ids")
    }
}
