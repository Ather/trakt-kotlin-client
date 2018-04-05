package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.Instant

data class TraktCollectionMovieImpl(
        @SerializedName("collected_at")
        override var collectedAt: Instant? = null,
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktCollectionMovie, TraktMovie by movie