package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl

interface TraktSyncRatingsPostResponseNotFoundMovie {
    var rating: Int?
    var ids: TraktMovieIdsImpl
}