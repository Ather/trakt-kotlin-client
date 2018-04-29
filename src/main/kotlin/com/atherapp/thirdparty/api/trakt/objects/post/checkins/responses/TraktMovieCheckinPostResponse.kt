package com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktMovieCheckinPostResponse : TraktCheckinPostResponse {
    var movie: TraktMovie

}
