package com.atherapp.thirdparty.api.trakt.objects.get.users.statistics.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.users.statistics.TraktUserRatingsStatistics

data class TraktUserRatingsStatisticsImpl(
        override var total: Int? = null,
        override var distribution: Map<String, Int> = mapOf()
) : TraktUserRatingsStatistics
