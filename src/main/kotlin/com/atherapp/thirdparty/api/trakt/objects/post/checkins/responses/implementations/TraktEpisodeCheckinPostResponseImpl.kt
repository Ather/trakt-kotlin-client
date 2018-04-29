package com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.TraktEpisodeCheckinPostResponse
import java.time.ZonedDateTime

data class TraktEpisodeCheckinPostResponseImpl(
        override var id: Long = 0,
        @SerializedName("watched_at") override var watchedAt: ZonedDateTime? = null,
        override var sharing: TraktSharing = TraktSharingImpl(),
        override var episode: TraktEpisode = TraktEpisodeImpl(),
        override var show: TraktShow = TraktShowImpl()
) : TraktEpisodeCheckinPostResponse
