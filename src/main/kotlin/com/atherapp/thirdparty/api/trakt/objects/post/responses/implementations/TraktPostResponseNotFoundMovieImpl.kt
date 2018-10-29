package com.atherapp.thirdparty.api.trakt.objects.post.responses.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktMovieIds
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundMovie

data class TraktPostResponseNotFoundMovieImpl(
        override var ids: TraktMovieIds = TraktMovieIds()
) : TraktPostResponseNotFoundMovie
