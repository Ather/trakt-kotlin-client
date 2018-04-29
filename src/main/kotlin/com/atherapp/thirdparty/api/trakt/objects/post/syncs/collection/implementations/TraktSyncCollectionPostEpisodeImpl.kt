package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktMetadata
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostEpisode
import java.time.ZonedDateTime

data class TraktSyncCollectionPostEpisodeImpl(
        @SerializedName("collected_at")
        override var collectedAt: ZonedDateTime? = null,
        override var ids: TraktEpisodeIds = TraktEpisodeIdsImpl(),
        override var metadata: TraktMetadata? = null
) : TraktSyncCollectionPostEpisode
