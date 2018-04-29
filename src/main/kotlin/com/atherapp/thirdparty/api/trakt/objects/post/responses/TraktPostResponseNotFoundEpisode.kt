package com.atherapp.thirdparty.api.trakt.objects.post.responses

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds

interface TraktPostResponseNotFoundEpisode {
    var ids: TraktEpisodeIds
}