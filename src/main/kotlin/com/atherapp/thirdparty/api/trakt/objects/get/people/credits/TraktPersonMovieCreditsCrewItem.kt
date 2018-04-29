package com.atherapp.thirdparty.api.trakt.objects.get.people.credits

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktPersonMovieCreditsCrewItem {
    var job: String

    var movie: TraktMovie

}
