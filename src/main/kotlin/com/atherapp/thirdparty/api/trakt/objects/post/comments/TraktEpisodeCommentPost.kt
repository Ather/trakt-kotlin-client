package com.atherapp.thirdparty.api.trakt.objects.post.comments

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode

interface TraktEpisodeCommentPost : TraktCommentPost {
    var episode: TraktEpisode
}
