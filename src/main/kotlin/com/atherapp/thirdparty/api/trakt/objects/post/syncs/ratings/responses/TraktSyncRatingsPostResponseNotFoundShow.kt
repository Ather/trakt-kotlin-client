package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import com.atherapp.thirdparty.api.trakt.core.TraktShowIds

interface TraktSyncRatingsPostResponseNotFoundShow {
    var rating: Int?
    var ids: TraktShowIds
}