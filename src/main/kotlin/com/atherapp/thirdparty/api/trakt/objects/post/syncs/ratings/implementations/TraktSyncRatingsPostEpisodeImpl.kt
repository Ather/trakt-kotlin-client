package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostEpisode
import java.time.ZonedDateTime

data class TraktSyncRatingsPostEpisodeImpl(
        override var ids: TraktEpisodeIds = TraktEpisodeIdsImpl(),
        override var rating: Int? = null,
        @SerializedName("rated_at")
        override var ratedAt: ZonedDateTime? = null
) : TraktSyncRatingsPostEpisode
