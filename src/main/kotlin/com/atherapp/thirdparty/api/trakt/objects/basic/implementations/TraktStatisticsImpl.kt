package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktStatistics

data class TraktStatisticsImpl(
        override var watchers: Int? = null,
        override var plays: Int? = null,
        override var collectors: Int? = null,
        @SerializedName("collected_episodes")
        override var collectedEpisodes: Int? = null,
        override var comments: Int? = null,
        override var lists: Int? = null,
        override var votes: Int? = null
) : TraktStatistics
