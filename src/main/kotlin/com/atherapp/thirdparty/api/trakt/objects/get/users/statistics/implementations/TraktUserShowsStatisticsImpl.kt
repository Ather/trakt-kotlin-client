package com.atherapp.thirdparty.api.trakt.objects.get.users.statistics.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.users.statistics.TraktUserShowsStatistics

data class TraktUserShowsStatisticsImpl(
        override var watched: Int? = null,
        override var collected: Int? = null,
        override var ratings: Int? = null,
        override var comments: Int? = null
) : TraktUserShowsStatistics
