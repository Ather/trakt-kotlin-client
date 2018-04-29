package com.atherapp.thirdparty.api.trakt.objects.get.syncs.activities.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncSeasonsLastActivities
import java.time.ZonedDateTime

data class TraktSyncSeasonsLastActivitiesImpl(
        @SerializedName("rated_at") override var ratedAt: ZonedDateTime? = null,
        @SerializedName("watchlisted_at") override var watchlistedAt: ZonedDateTime? = null,
        @SerializedName("commented_at") override var commentedAt: ZonedDateTime? = null,
        @SerializedName("hidden_at") override var hiddenAt: ZonedDateTime? = null
) : TraktSyncSeasonsLastActivities
