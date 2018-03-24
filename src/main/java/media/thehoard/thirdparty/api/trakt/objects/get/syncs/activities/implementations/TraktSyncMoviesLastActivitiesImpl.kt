package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncMoviesLastActivities

import java.time.Instant

data class TraktSyncMoviesLastActivitiesImpl(
        @SerializedName("watched_at") override var watchedAt: Instant? = null,
        @SerializedName("collected_at") override var collectedAt: Instant? = null,
        @SerializedName("rated_at") override var ratedAt: Instant? = null,
        @SerializedName("watchlisted_at") override var watchlistedAt: Instant? = null,
        @SerializedName("commented_at") override var commentedAt: Instant? = null,
        @SerializedName("paused_at") override var pausedAt: Instant? = null,
        @SerializedName("hidden_at") override var hiddenAt: Instant? = null
) : TraktSyncMoviesLastActivities
