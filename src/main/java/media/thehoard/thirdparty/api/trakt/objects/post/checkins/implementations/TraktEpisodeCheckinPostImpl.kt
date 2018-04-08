package media.thehoard.thirdparty.api.trakt.objects.post.checkins.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.TraktEpisodeCheckinPost
import media.thehoard.thirdparty.api.trakt.utils.Json

data class TraktEpisodeCheckinPostImpl(
        override var sharing: TraktSharingImpl? = TraktSharingImpl(),
        override var message: String? = null,
        @SerializedName("app_version") override var appVersion: String? = null,
        @SerializedName("app_date") override var appDate: String? = null,
        @SerializedName("venue_id") override var foursquareVenueId: String? = null,
        @SerializedName("venue_name") override var foursquareVenueName: String? = null,
        override var episode: TraktEpisodeImpl = TraktEpisodeImpl(),
        override var show: TraktShowImpl? = TraktShowImpl()
) : TraktEpisodeCheckinPost {
    override fun toJson(): String = Json.serialize(this)

    override fun validate(variableName: String) {
        if (show != null) show?.validateWithEpisode(episode)
        else episode.validate("episode")
    }
}
