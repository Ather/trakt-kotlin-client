package media.thehoard.thirdparty.api.trakt.objects.post.checkins.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.TraktEpisodeCheckinPost

data class TraktEpisodeCheckinPostImpl(
        override var sharing: TraktSharingImpl = TraktSharingImpl(),
        override var message: String = "",
        @SerializedName("app_version") override var appVersion: String = "",
        @SerializedName("app_date") override var appDate: String = "",
        @SerializedName("venue_id") override var foursquareVenueId: String = "",
        @SerializedName("venue_name") override var foursquareVenueName: String = "",
        override var episode: TraktEpisodeImpl = TraktEpisodeImpl(),
        override var show: TraktShowImpl = TraktShowImpl()
) : TraktEpisodeCheckinPost
