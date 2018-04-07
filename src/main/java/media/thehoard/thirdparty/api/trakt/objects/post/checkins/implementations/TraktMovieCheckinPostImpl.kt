package media.thehoard.thirdparty.api.trakt.objects.post.checkins.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.TraktMovieCheckinPost
import media.thehoard.thirdparty.api.trakt.utils.Json

data class TraktMovieCheckinPostImpl(
        override var sharing: TraktSharingImpl? = null,
        override var message: String? = null,
        @SerializedName("app_version") override var appVersion: String? = null,
        @SerializedName("app_date") override var appDate: String? = null,
        @SerializedName("venue_id") override var foursquareVenueId: String? = null,
        @SerializedName("venue_name") override var foursquareVenueName: String? = null,
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktMovieCheckinPost {
    override fun toJson(): String = Json.serialize(this)

    override fun validate() {}
}
