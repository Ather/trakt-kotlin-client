package com.atherapp.thirdparty.api.trakt.objects.get.users.statistics.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.users.statistics.TraktUserSeasonsStatistics

data class TraktUserSeasonsStatisticsImpl(
        override var ratings: Int? = null,
        override var comments: Int? = null
) : TraktUserSeasonsStatistics
