package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import com.atherapp.thirdparty.api.trakt.core.TraktMovieIds

interface TraktSyncRatingsPostResponseNotFoundMovie {
    var rating: Int?
    var ids: TraktMovieIds
}