package com.atherapp.thirdparty.api.trakt.objects.post.checkins

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktMovieCheckinPost : TraktCheckinPost {
    var movie: TraktMovie
}
