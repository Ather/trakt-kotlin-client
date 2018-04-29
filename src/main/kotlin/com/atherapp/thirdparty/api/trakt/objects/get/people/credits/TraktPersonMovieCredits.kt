package com.atherapp.thirdparty.api.trakt.objects.get.people.credits

interface TraktPersonMovieCredits {
    var cast: List<TraktPersonMovieCreditsCastItem>

    var crew: TraktPersonMovieCreditsCrew

}
