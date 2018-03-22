package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktRecentlyUpdatedMovie
import java.util.*

data class TraktRecentlyUpdatedMovieImpl(@SerializedName("updated_at")
                                         override var updatedAt: Date? = null,
                                         override var movie: TraktMovieImpl = TraktMovieImpl()) : TraktRecentlyUpdatedMovie {
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
