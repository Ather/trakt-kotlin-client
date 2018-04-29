package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl

interface TraktSyncRatingsPostResponseNotFoundEpisode {
    var rating: Int?
    var ids: TraktEpisodeIdsImpl
}