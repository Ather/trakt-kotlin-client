package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.Instant

data class TraktCollectionMovieImpl(
        @SerializedName("collected_at")
        override var collectedAt: Instant? = null,
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktCollectionMovie {

    override var title: String
        get() = movie.title
        set(title) {
            movie.title = title
        }

    override var year: Int?
        get() = movie.year
        set(year) {
            movie.year = year
        }

    override var ids: TraktMovieIdsImpl
        get() = movie.ids
        set(ids) {
            movie.ids = ids
        }
}