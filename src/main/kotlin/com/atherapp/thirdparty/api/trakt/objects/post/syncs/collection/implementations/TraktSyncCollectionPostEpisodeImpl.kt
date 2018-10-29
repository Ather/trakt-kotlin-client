package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktEpisodeIds
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktMetadata
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostEpisode
import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime

data class TraktSyncCollectionPostEpisodeImpl(
        @SerializedName("collected_at")
        override var collectedAt: ZonedDateTime? = null,
        override var ids: TraktEpisodeIds = TraktEpisodeIds(),
        override var metadata: TraktMetadata? = null
) : TraktSyncCollectionPostEpisode
