package com.atherapp.thirdparty.api.trakt.objects.post.responses.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktSeasonIds
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundSeason

data class TraktPostResponseNotFoundSeasonImpl(
        override var ids: TraktSeasonIds = TraktSeasonIds()
) : TraktPostResponseNotFoundSeason
