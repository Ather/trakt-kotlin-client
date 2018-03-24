package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncShowsLastActivities

import java.time.Instant

data class TraktSyncShowsLastActivitiesImpl(
        @SerializedName("rated_at") override var ratedAt: Instant? = null,
        @SerializedName("watchlisted_at") override var watchlistedAt: Instant? = null,
        @SerializedName("commented_at") override var commentedAt: Instant? = null,
        @SerializedName("hidden_at") override var hiddenAt: Instant? = null
) : TraktSyncShowsLastActivities
