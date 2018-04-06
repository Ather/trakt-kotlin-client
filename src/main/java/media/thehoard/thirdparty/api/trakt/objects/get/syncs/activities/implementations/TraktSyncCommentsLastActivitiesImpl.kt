package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncCommentsLastActivities
import java.time.ZonedDateTime

data class TraktSyncCommentsLastActivitiesImpl(
        @SerializedName("liked_at")
        override var likedAt: ZonedDateTime? = null
) : TraktSyncCommentsLastActivities
