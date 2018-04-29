package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsPostResponseNotFoundMovie

data class TraktSyncRatingsPostResponseNotFoundMovieImpl(
        override var rating: Int? = null,
        override var ids: TraktMovieIdsImpl = TraktMovieIdsImpl()
) : TraktSyncRatingsPostResponseNotFoundMovie
