package com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeProgress

data class TraktEpisodeProgressImpl(
        override var number: Int? = null,
        override var completed: Boolean? = null
) : TraktEpisodeProgress
