package com.atherapp.thirdparty.api.trakt.objects.post.responses.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovieIds
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundMovie

data class TraktPostResponseNotFoundMovieImpl(
        override var ids: TraktMovieIds = TraktMovieIdsImpl()
) : TraktPostResponseNotFoundMovie
