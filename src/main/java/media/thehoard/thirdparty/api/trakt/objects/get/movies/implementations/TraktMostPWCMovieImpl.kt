package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMostPWCMovie

data class TraktMostPWCMovieImpl(@SerializedName("watcher_count")
                                 override var watcherCount: Int? = null,
                                 @SerializedName("play_count")
                                 override var playCount: Int? = null,
                                 @SerializedName("collected_count")
                                 override var collectedCount: Int? = null,
                                 override var movie: TraktMovieImpl = TraktMovieImpl()) : TraktMostPWCMovie {
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
