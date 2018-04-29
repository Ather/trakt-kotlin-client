package com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovieAlias

data class TraktMovieAliasImpl(
        override var title: String = "",
        override var country: String = ""
) : TraktMovieAlias
