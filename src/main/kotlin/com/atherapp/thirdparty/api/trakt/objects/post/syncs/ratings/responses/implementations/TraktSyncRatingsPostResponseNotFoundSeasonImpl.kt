package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsPostResponseNotFoundSeason

data class TraktSyncRatingsPostResponseNotFoundSeasonImpl(
        override var rating: Int? = null,
        override var ids: TraktSeasonIdsImpl = TraktSeasonIdsImpl()
) : TraktSyncRatingsPostResponseNotFoundSeason
