package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostShow
import java.time.Instant

data class TraktSyncCollectionPostShowImpl(
        @SerializedName("collected_at")
        override var collectedAt: Instant? = null,
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktShowIdsImpl = TraktShowIdsImpl(),
        override var metadata: TraktMetadataImpl? = null,
        override var seasons: MutableList<TraktSyncCollectionPostShowSeasonImpl> = mutableListOf()
) : TraktSyncCollectionPostShow
