package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncListsLastActivities

import java.time.Instant

data class TraktSyncListsLastActivitiesImpl(
        @SerializedName("liked_at") override var likedAt: Instant? = null,
        @SerializedName("updated_at") override var updatedAt: Instant? = null,
        @SerializedName("commented_at") override var commentedAt: Instant? = null
) : TraktSyncListsLastActivities
