package com.atherapp.thirdparty.api.trakt.objects.get.collections.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktMetadata
import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowEpisode
import java.time.ZonedDateTime

data class TraktCollectionShowEpisodeImpl(
        override var number: Int? = null,
        @SerializedName("collected_at")
        override var collectedAt: ZonedDateTime? = null,
        override var metadata: TraktMetadata? = null
) : TraktCollectionShowEpisode
