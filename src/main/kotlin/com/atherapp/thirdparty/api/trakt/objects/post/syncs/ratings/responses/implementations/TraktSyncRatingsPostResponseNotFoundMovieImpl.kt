package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktMovieIds
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsPostResponseNotFoundMovie

data class TraktSyncRatingsPostResponseNotFoundMovieImpl(
        override var rating: Int? = null,
        override var ids: TraktMovieIds = TraktMovieIds()
) : TraktSyncRatingsPostResponseNotFoundMovie
