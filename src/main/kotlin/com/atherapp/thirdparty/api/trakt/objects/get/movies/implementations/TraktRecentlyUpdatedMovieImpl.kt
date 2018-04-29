package com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktRecentlyUpdatedMovie
import java.time.ZonedDateTime

data class TraktRecentlyUpdatedMovieImpl(
        @SerializedName("updated_at")
        override var recentlyUpdatedAt: ZonedDateTime? = null,
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktRecentlyUpdatedMovie, TraktMovie by movie
