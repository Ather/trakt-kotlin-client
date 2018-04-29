package com.atherapp.thirdparty.api.trakt.objects.post.checkins.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.TraktMovieCheckinPost
import com.atherapp.thirdparty.api.trakt.utils.Json

data class TraktMovieCheckinPostImpl(
        override var sharing: TraktSharing? = null,
        override var message: String? = null,
        @SerializedName("app_version") override var appVersion: String? = null,
        @SerializedName("app_date") override var appDate: String? = null,
        @SerializedName("venue_id") override var foursquareVenueId: String? = null,
        @SerializedName("venue_name") override var foursquareVenueName: String? = null,
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktMovieCheckinPost {
    override fun toJson(): String = Json.serialize(this)

    override fun validate(variableName: String) = movie.validate("movie")
}
