package com.atherapp.thirdparty.api.trakt.objects.get.watched.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.watched.TraktWatchedMovie
import java.time.ZonedDateTime

data class TraktWatchedMovieImpl(
        override var plays: Int? = null,
        @SerializedName("last_watched_at") override var lastWatchedAt: ZonedDateTime? = null,
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktWatchedMovie
