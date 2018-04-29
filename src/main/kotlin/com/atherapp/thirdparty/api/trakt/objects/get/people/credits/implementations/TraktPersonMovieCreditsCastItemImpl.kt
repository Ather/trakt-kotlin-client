package com.atherapp.thirdparty.api.trakt.objects.get.people.credits.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCastItem

data class TraktPersonMovieCreditsCastItemImpl(
        override var character: String = "",
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktPersonMovieCreditsCastItem
