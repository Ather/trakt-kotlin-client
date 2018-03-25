package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostShowEpisode
import java.time.Instant

data class TraktSyncRatingsPostShowEpisodeImpl(
        override var number: Int = 0,
        override var rating: Int? = null,
        @SerializedName("rated_at")
        override var ratedAt: Instant? = null
) : TraktSyncRatingsPostShowEpisode
