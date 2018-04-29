package com.atherapp.thirdparty.api.trakt.objects.get.users.statistics.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.users.statistics.TraktUserMoviesStatistics

data class TraktUserMoviesStatisticsImpl(
        override var plays: Int? = null,
        override var watched: Int? = null,
        override var minutes: Int? = null,
        override var collected: Int? = null,
        override var ratings: Int? = null,
        override var comments: Int? = null
) : TraktUserMoviesStatistics
