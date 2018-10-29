package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktShowIds
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsPostResponseNotFoundShow

data class TraktSyncRatingsPostResponseNotFoundShowImpl(
        override var rating: Int? = null,
        override var ids: TraktShowIds = TraktShowIds()
) : TraktSyncRatingsPostResponseNotFoundShow
