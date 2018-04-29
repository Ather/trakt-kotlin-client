package com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShowTranslation

data class TraktShowTranslationImpl(
        override var title: String = "",
        override var overview: String? = null,
        override var language: String? = null
) : TraktShowTranslation
