package com.atherapp.thirdparty.api.trakt.objects.get.syncs.activities.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncMoviesLastActivities
import java.time.ZonedDateTime

data class TraktSyncMoviesLastActivitiesImpl(
        @SerializedName("watched_at") override var watchedAt: ZonedDateTime? = null,
        @SerializedName("collected_at") override var collectedAt: ZonedDateTime? = null,
        @SerializedName("rated_at") override var ratedAt: ZonedDateTime? = null,
        @SerializedName("watchlisted_at") override var watchlistedAt: ZonedDateTime? = null,
        @SerializedName("commented_at") override var commentedAt: ZonedDateTime? = null,
        @SerializedName("paused_at") override var pausedAt: ZonedDateTime? = null,
        @SerializedName("hidden_at") override var hiddenAt: ZonedDateTime? = null
) : TraktSyncMoviesLastActivities
