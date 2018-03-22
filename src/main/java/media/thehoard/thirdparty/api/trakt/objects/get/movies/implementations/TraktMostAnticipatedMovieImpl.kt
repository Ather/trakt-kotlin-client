package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMostAnticipatedMovie

data class TraktMostAnticipatedMovieImpl(@SerializedName("list_count")
                                         override var listCount: Int? = null,
                                         override var movie: TraktMovieImpl = TraktMovieImpl()) : TraktMostAnticipatedMovie {
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
