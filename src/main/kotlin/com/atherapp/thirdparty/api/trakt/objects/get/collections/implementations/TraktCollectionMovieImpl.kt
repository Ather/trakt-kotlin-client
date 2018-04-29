package com.atherapp.thirdparty.api.trakt.objects.get.collections.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktMetadata
import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import java.time.ZonedDateTime

data class TraktCollectionMovieImpl(
        @SerializedName("collected_at")
        override var collectedAt: ZonedDateTime? = null,
        override var movie: TraktMovie = TraktMovieImpl(),
        override var metadata: TraktMetadata? = null
) : TraktCollectionMovie, TraktMovie by movie
