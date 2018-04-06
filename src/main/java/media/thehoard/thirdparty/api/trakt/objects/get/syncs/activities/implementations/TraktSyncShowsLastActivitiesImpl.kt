package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncShowsLastActivities
import java.time.ZonedDateTime

data class TraktSyncShowsLastActivitiesImpl(
        @SerializedName("rated_at") override var ratedAt: ZonedDateTime? = null,
        @SerializedName("watchlisted_at") override var watchlistedAt: ZonedDateTime? = null,
        @SerializedName("commented_at") override var commentedAt: ZonedDateTime? = null,
        @SerializedName("hidden_at") override var hiddenAt: ZonedDateTime? = null
) : TraktSyncShowsLastActivities
