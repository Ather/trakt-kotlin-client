package com.atherapp.thirdparty.api.trakt.objects.post.responses.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundEpisode

data class TraktPostResponseNotFoundEpisodeImpl(
        override var ids: TraktEpisodeIds = TraktEpisodeIdsImpl()
) : TraktPostResponseNotFoundEpisode
