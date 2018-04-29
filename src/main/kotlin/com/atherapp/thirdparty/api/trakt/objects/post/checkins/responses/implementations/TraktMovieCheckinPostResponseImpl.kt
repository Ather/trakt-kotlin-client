package com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.TraktMovieCheckinPostResponse
import java.time.ZonedDateTime

data class TraktMovieCheckinPostResponseImpl(
        override var id: Long = 0,
        @SerializedName("watched_at") override var watchedAt: ZonedDateTime? = null,
        override var sharing: TraktSharing = TraktSharingImpl(),
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktMovieCheckinPostResponse
