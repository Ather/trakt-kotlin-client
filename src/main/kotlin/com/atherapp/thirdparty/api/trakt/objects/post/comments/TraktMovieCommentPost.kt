package com.atherapp.thirdparty.api.trakt.objects.post.comments

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktMovieCommentPost : TraktCommentPost {
    var movie: TraktMovie
}
