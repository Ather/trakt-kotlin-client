package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktRecentlyUpdatedMovie
import java.time.Instant

data class TraktRecentlyUpdatedMovieImpl(
        @SerializedName("updated_at")
        override var updatedAt: Instant? = null,
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktRecentlyUpdatedMovie, TraktMovie by movie
