package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.ZonedDateTime

data class TraktCollectionMovieImpl(
        @SerializedName("collected_at")
        override var collectedAt: ZonedDateTime? = null,
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktCollectionMovie, TraktMovie by movie