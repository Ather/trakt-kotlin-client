package com.atherapp.thirdparty.api.trakt.objects.post.scrobbles

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktMovieScrobblePost : TraktScrobblePost {
    var movie: TraktMovie
}