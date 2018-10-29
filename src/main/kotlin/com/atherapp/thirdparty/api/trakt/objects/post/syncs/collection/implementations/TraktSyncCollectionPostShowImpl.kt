package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktShowIds
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktMetadata
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostShow
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostShowSeason
import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime

data class TraktSyncCollectionPostShowImpl(
        @SerializedName("collected_at")
        override var collectedAt: ZonedDateTime? = null,
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktShowIds = TraktShowIds(),
        override var metadata: TraktMetadata? = null,
        override var seasons: MutableList<TraktSyncCollectionPostShowSeason> = mutableListOf()
) : TraktSyncCollectionPostShow
