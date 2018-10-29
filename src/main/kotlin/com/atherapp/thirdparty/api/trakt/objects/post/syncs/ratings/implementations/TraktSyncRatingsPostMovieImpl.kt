package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktMovieIds
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostMovie
import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime

data class TraktSyncRatingsPostMovieImpl(
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktMovieIds = TraktMovieIds(),
        override var rating: Int? = null,
        @SerializedName("rated_at")
        override var ratedAt: ZonedDateTime? = null
) : TraktSyncRatingsPostMovie
