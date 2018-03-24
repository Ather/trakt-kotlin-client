package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieExtendedFull
import java.time.Instant

data class TraktMovieExtendedFullImpl(override var title: String = "",
                                      override var year: Int? = null,
                                      override var ids: TraktMovieIdsImpl = TraktMovieIdsImpl(),
                                      override var tagline: String = "",
                                      override var overview: String = "",
                                      override var released: Instant? = null,
                                      override var runtime: Int? = null,
                                      @SerializedName("updated_at")
                                      override var updatedAt: Instant? = null,
                                      override var trailer: String = "",
                                      override var homepage: String = "",
                                      override var rating: Float? = null,
                                      override var votes: Int? = null,
                                      @SerializedName("comment_count") override var commentCount: Int? = null,
                                      override var language: String = "",
                                      @SerializedName("available_translations")
                                      override var availableTranslations: List<String> = listOf(),
                                      override var genres: List<String> = listOf(),
                                      override var certification: String = "") : TraktMovieExtendedFull {
    constructor(traktMovie: TraktMovie) : this(traktMovie.title, traktMovie.year, traktMovie.ids)
}
