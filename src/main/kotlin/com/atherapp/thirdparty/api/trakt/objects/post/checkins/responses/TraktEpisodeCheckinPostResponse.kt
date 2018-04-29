package com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktEpisodeCheckinPostResponse : TraktCheckinPostResponse {
    var episode: TraktEpisode

    var show: TraktShow

}
