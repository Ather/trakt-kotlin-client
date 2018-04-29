package com.atherapp.thirdparty.api.trakt.objects.get.people.credits

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktPersonMovieCreditsCastItem {
    var character: String

    var movie: TraktMovie

}
