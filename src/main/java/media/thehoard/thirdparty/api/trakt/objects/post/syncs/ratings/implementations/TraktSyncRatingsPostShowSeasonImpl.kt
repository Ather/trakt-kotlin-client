package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostShowSeason
import java.time.Instant

data class TraktSyncRatingsPostShowSeasonImpl(
        override var number: Int = 0,
        override var rating: Int? = null,
        @SerializedName("rated_at")
        override var ratedAt: Instant? = null,
        override var episodes: MutableList<TraktSyncRatingsPostShowEpisodeImpl> = mutableListOf()
) : TraktSyncRatingsPostShowSeason
