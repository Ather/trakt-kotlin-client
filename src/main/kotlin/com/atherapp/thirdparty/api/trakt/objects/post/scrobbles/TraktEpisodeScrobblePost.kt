package com.atherapp.thirdparty.api.trakt.objects.post.scrobbles

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktEpisodeScrobblePost : TraktScrobblePost {
    var episode: TraktEpisode

    var show: TraktShow?
}