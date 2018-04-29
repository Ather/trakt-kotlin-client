package com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktTrendingShow

data class TraktTrendingShowImpl(
        override var watchers: Int? = null,
        override var show: TraktShow = TraktShowImpl()
) : TraktTrendingShow, TraktShow by show