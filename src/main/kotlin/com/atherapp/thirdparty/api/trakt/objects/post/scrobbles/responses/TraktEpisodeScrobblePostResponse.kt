package com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.responses

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktEpisodeScrobblePostResponse : TraktScrobblePostResponse {
    var episode: TraktEpisode

    var show: TraktShow?
}