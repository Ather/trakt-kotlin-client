package com.atherapp.thirdparty.api.trakt.objects.get.syncs.playback

import com.atherapp.thirdparty.api.trakt.enums.TraktSyncType
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktSyncPlaybackProgressItem {
    var id: Int

    var progress: Float?

    var pausedAt: ZonedDateTime?

    var type: TraktSyncType

    var movie: TraktMovie

    var episode: TraktEpisode

    var show: TraktShow

}
