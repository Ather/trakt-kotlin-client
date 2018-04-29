package com.atherapp.thirdparty.api.trakt.objects.get.syncs.playback.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.enums.TraktSyncType
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import com.atherapp.thirdparty.api.trakt.objects.get.syncs.playback.TraktSyncPlaybackProgressItem
import java.time.ZonedDateTime

data class TraktSyncPlaybackProgressItemImpl(
        override var id: Int = 0,
        override var progress: Float? = null,
        @SerializedName("pause_at") override var pausedAt: ZonedDateTime? = null,
        override var type: TraktSyncType = TraktSyncType.UNSPECIFIED,
        override var movie: TraktMovie = TraktMovieImpl(),
        override var episode: TraktEpisode = TraktEpisodeImpl(),
        override var show: TraktShow = TraktShowImpl()
) : TraktSyncPlaybackProgressItem
