package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowEpisode
import java.time.ZonedDateTime

data class TraktCollectionShowEpisodeImpl(
        override var number: Int? = null,
        @SerializedName("collected_at")
        override var collectedAt: ZonedDateTime? = null
) : TraktCollectionShowEpisode
