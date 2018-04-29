package com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeasonProgress

data class TraktSeasonProgressImpl(
        override var number: Int? = null,
        override var aired: Int? = null,
        override var completed: Int? = null
) : TraktSeasonProgress
