package com.atherapp.thirdparty.api.trakt.objects.post.responses.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeasonIds
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundSeason

data class TraktPostResponseNotFoundSeasonImpl(
        override var ids: TraktSeasonIds = TraktSeasonIdsImpl()
) : TraktPostResponseNotFoundSeason
