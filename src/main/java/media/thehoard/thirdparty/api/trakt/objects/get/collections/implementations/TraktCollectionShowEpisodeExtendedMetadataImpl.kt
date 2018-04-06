package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowEpisodeExtendedMetadata
import java.time.ZonedDateTime

data class TraktCollectionShowEpisodeExtendedMetadataImpl(
        override var number: Int? = null,
        @SerializedName("collected_at")
        override var collectedAt: ZonedDateTime? = null,
        override var metadata: TraktMetadataImpl = TraktMetadataImpl()
) : TraktCollectionShowEpisodeExtendedMetadata
