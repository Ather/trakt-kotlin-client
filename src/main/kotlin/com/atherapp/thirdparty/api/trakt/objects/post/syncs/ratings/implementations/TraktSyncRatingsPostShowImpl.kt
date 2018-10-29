package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktShowIds
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostShow
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostShowSeason
import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime

data class TraktSyncRatingsPostShowImpl(
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktShowIds = TraktShowIds(),
        override var rating: Int? = null,
        @SerializedName("rated_at")
        override var ratedAt: ZonedDateTime? = null,
        override var seasons: MutableList<TraktSyncRatingsPostShowSeason> = mutableListOf()
) : TraktSyncRatingsPostShow
