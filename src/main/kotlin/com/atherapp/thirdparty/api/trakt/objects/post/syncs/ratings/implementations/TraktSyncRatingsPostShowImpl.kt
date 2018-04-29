package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShowIds
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostShow
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostShowSeason
import java.time.ZonedDateTime

data class TraktSyncRatingsPostShowImpl(
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktShowIds = TraktShowIdsImpl(),
        override var rating: Int? = null,
        @SerializedName("rated_at")
        override var ratedAt: ZonedDateTime? = null,
        override var seasons: MutableList<TraktSyncRatingsPostShowSeason> = mutableListOf()
) : TraktSyncRatingsPostShow
