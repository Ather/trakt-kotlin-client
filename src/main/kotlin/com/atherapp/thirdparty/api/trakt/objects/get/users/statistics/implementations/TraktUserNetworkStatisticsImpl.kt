package com.atherapp.thirdparty.api.trakt.objects.get.users.statistics.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.users.statistics.TraktUserNetworkStatistics

data class TraktUserNetworkStatisticsImpl(
        override var friends: Int? = null,
        override var followers: Int? = null,
        override var following: Int? = null
) : TraktUserNetworkStatistics
