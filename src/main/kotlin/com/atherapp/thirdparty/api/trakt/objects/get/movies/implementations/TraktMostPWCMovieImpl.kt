package com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMostPWCMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie

data class TraktMostPWCMovieImpl(
        @SerializedName("watcher_count")
        override var watcherCount: Int? = null,
        @SerializedName("play_count")
        override var playCount: Int? = null,
        @SerializedName("collected_count")
        override var collectedCount: Int? = null,
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktMostPWCMovie, TraktMovie by movie
