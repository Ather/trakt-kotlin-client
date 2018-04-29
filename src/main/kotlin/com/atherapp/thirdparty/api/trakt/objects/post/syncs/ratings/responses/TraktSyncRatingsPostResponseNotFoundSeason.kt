package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonIdsImpl

interface TraktSyncRatingsPostResponseNotFoundSeason {
    var rating: Int?
    var ids: TraktSeasonIdsImpl
}