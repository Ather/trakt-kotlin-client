package com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMostAnticipatedMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie

data class TraktMostAnticipatedMovieImpl(
        @SerializedName("list_count")
        override var listCount: Int? = null,
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktMostAnticipatedMovie, TraktMovie by movie
