package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktEpisodeCheckinPostResponse
import java.time.ZonedDateTime

data class TraktEpisodeCheckinPostResponseImpl(
        override var id: Long = 0,
        @SerializedName("watched_at") override var watchedAt: ZonedDateTime? = null,
        override var sharing: TraktSharingImpl = TraktSharingImpl(),
        override var episode: TraktEpisodeImpl = TraktEpisodeImpl(),
        override var show: TraktShowImpl = TraktShowImpl()
) : TraktEpisodeCheckinPostResponse
