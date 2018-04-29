package com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktTrendingMovie

data class TraktTrendingMovieImpl(
        override var watchers: Int? = null,
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktTrendingMovie, TraktMovie by movie
