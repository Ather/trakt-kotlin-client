package com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovieTranslation

class TraktMovieTranslationImpl(
        override var title: String = "",
        override var overview: String? = null,
        override var language: String? = null,
        override var tagline: String? = null
) : TraktMovieTranslation
