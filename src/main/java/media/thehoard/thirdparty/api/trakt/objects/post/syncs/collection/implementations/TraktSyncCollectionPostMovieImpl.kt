package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktMetadata
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostMovie
import java.time.ZonedDateTime

data class TraktSyncCollectionPostMovieImpl(
        @SerializedName("collected_at")
        override var collectedAt: ZonedDateTime? = null,
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktMovieIds = TraktMovieIdsImpl(),
        override var metadata: TraktMetadata? = null
) : TraktSyncCollectionPostMovie