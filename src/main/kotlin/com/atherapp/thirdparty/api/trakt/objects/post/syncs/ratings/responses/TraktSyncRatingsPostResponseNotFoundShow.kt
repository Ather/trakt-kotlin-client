package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl

interface TraktSyncRatingsPostResponseNotFoundShow {
    var rating: Int?
    var ids: TraktShowIdsImpl
}