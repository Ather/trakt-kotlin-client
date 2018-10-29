package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import com.atherapp.thirdparty.api.trakt.core.TraktEpisodeIds

interface TraktSyncRatingsPostResponseNotFoundEpisode {
    var rating: Int?
    var ids: TraktEpisodeIds
}