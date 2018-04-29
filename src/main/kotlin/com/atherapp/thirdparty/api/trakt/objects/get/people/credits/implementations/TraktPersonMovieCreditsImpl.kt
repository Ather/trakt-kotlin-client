package com.atherapp.thirdparty.api.trakt.objects.get.people.credits.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCredits
import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCastItem
import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCrew

data class TraktPersonMovieCreditsImpl(
        override var cast: List<TraktPersonMovieCreditsCastItem> = listOf(),
        override var crew: TraktPersonMovieCreditsCrew = TraktPersonMovieCreditsCrewImpl()
) : TraktPersonMovieCredits
