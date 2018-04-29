package com.atherapp.thirdparty.api.trakt.objects.get.people.credits.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCrewItem

data class TraktPersonMovieCreditsCrewItemImpl(
        override var job: String = "",
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktPersonMovieCreditsCrewItem
