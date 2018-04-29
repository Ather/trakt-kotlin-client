package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostShowEpisode
import java.time.ZonedDateTime

data class TraktSyncRatingsPostShowEpisodeImpl(
        override var number: Int = 0,
        override var rating: Int? = null,
        @SerializedName("rated_at")
        override var ratedAt: ZonedDateTime? = null
) : TraktSyncRatingsPostShowEpisode
