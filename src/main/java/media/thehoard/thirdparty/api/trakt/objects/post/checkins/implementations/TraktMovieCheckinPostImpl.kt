package media.thehoard.thirdparty.api.trakt.objects.post.checkins.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.TraktMovieCheckinPost

data class TraktMovieCheckinPostImpl(override var sharing: TraktSharingImpl,
                                     override var message: String,
                                     @SerializedName("app_version") override var appVersion: String,
                                     @SerializedName("app_date") override var appDate: String,
                                     @SerializedName("venue_id") override var foursquareVenueId: String,
                                     @SerializedName("venue_name") override var foursquareVenueName: String,
                                     override var movie: TraktMovieImpl) : TraktMovieCheckinPost
