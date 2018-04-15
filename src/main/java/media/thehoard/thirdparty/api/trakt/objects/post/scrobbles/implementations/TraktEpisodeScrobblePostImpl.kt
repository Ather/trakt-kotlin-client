package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.extensions.isNotNegative
import media.thehoard.thirdparty.api.trakt.extensions.isPositive
import media.thehoard.thirdparty.api.trakt.extensions.isValidProgress
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.TraktEpisodeScrobblePost

data class TraktEpisodeScrobblePostImpl(
        override var progress: Float = 0f,
        @SerializedName("app_version")
        override var appVersion: String? = null,
        @SerializedName("app_date")
        override var appDate: String? = null,
        override var episode: TraktEpisode = TraktEpisodeImpl(),
        override var show: TraktShow? = null
) : TraktEpisodeScrobblePost {
    override fun validate(variableName: String) {
        progress.validate("progress value not valid - value must be between 0 and 100", ::isValidProgress, null)

        if (!episode.ids.hasAnyId()) {
            show?.title.validate("episode ids not set or have no valid id - show title not valid", String::isNullOrBlank, null)
            episode.season.validate("season number", ::isNotNegative)
            episode.number.validate("episode number", ::isPositive)
        }
    }
}