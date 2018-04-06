package media.thehoard.thirdparty.api.trakt.objects.get.syncs.playback.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.playback.TraktSyncPlaybackProgressItem
import java.time.ZonedDateTime

data class TraktSyncPlaybackProgressItemImpl(
        override var id: Int = 0,
        override var progress: Float? = null,
        @SerializedName("pause_at") override var pausedAt: ZonedDateTime? = null,
        override var type: TraktSyncType = TraktSyncType.UNSPECIFIED,
        override var movie: TraktMovieImpl = TraktMovieImpl(),
        override var episode: TraktEpisodeImpl = TraktEpisodeImpl(),
        override var show: TraktShowImpl = TraktShowImpl()
) : TraktSyncPlaybackProgressItem
