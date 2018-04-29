package com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktBoxOfficeMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie

data class TraktBoxOfficeMovieImpl(
        override var revenue: Long? = null,
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktBoxOfficeMovie, TraktMovie by movie