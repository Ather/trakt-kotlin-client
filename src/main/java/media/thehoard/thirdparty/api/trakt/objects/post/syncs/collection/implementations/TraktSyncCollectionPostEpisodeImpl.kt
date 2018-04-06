package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostEpisode
import java.time.ZonedDateTime

data class TraktSyncCollectionPostEpisodeImpl(
        @SerializedName("collected_at")
        override var collectedAt: ZonedDateTime? = null,
        override var ids: TraktEpisodeIdsImpl = TraktEpisodeIdsImpl(),
        override var metadata: TraktMetadataImpl? = null
) : TraktSyncCollectionPostEpisode
