package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncListsLastActivities
import java.time.ZonedDateTime

data class TraktSyncListsLastActivitiesImpl(
        @SerializedName("liked_at") override var likedAt: ZonedDateTime? = null,
        @SerializedName("updated_at") override var updatedAt: ZonedDateTime? = null,
        @SerializedName("commented_at") override var commentedAt: ZonedDateTime? = null
) : TraktSyncListsLastActivities
