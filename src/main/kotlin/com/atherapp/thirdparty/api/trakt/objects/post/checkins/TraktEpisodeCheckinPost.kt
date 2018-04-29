package com.atherapp.thirdparty.api.trakt.objects.post.checkins

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktEpisodeCheckinPost : TraktCheckinPost {
    var episode: TraktEpisode

    var show: TraktShow?
}
