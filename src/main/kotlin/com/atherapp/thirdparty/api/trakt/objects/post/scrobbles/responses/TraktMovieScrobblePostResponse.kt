package com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.responses

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktMovieScrobblePostResponse : TraktScrobblePostResponse {
    var movie: TraktMovie
}