package com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeCollectionProgress
import java.time.ZonedDateTime

data class TraktEpisodeCollectionProgressImpl(
        override var number: Int? = null,
        override var completed: Boolean? = null,
        @SerializedName("collected_at")
        override var collectedAt: ZonedDateTime? = null
) : TraktEpisodeCollectionProgress
