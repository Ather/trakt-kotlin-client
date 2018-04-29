package com.atherapp.thirdparty.api.trakt.objects.post.responses

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovieIds

interface TraktPostResponseNotFoundMovie {
    var ids: TraktMovieIds
}