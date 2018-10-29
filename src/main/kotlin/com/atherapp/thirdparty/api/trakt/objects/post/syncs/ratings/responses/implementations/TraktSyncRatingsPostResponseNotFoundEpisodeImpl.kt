package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktEpisodeIds
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsPostResponseNotFoundEpisode

data class TraktSyncRatingsPostResponseNotFoundEpisodeImpl(
        override var rating: Int? = null,
        override var ids: TraktEpisodeIds = TraktEpisodeIds()
) : TraktSyncRatingsPostResponseNotFoundEpisode
