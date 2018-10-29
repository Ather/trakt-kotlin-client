package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import com.atherapp.thirdparty.api.trakt.core.TraktSeasonIds

interface TraktSyncRatingsPostResponseNotFoundSeason {
    var rating: Int?
    var ids: TraktSeasonIds
}