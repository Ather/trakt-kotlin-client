package media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedMovie

import java.time.Instant

data class TraktWatchedMovieImpl(
        override var plays: Int? = null,
        @SerializedName("last_watched_at") override var lastWatchedAt: Instant? = null,
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktWatchedMovie
