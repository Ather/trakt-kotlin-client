package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionMovieExtendedMetadata
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.Instant

data class TraktCollectionMovieExtendedMetadataImpl(
        @SerializedName("collected_at")
        override var collectedAt: Instant? = null,
        override var movie: TraktMovieImpl = TraktMovieImpl(),
        override var metadata: TraktMetadataImpl = TraktMetadataImpl()
) : TraktCollectionMovieExtendedMetadata, TraktMovie by movie
