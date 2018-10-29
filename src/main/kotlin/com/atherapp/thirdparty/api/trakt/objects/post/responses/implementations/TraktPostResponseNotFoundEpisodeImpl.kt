package com.atherapp.thirdparty.api.trakt.objects.post.responses.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktEpisodeIds
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundEpisode

data class TraktPostResponseNotFoundEpisodeImpl(
        override var ids: TraktEpisodeIds = TraktEpisodeIds()
) : TraktPostResponseNotFoundEpisode
