package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMostPWCMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie

data class TraktMostPWCMovieImpl(
        @SerializedName("watcher_count")
        override var watcherCount: Int? = null,
        @SerializedName("play_count")
        override var playCount: Int? = null,
        @SerializedName("collected_count")
        override var collectedCount: Int? = null,
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktMostPWCMovie, TraktMovie by movie
