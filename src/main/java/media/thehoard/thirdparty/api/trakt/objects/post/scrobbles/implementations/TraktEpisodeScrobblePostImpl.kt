package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.TraktEpisodeScrobblePost

data class TraktEpisodeScrobblePostImpl(
        override var progress: Float = 0f,
        @SerializedName("app_version")
        override var appVersion: String? = null,
        @SerializedName("app_date")
        override var appDate: String? = null,
        override var episode: TraktEpisode = TraktEpisodeImpl(),
        override var show: TraktShow = TraktShowImpl()
) : TraktEpisodeScrobblePost