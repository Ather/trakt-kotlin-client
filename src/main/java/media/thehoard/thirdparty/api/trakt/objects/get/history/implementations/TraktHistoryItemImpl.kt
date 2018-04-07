package media.thehoard.thirdparty.api.trakt.objects.get.history.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktHistoryActionType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncItemType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.history.TraktHistoryItem
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

data class TraktHistoryItemImpl(
        override var id: Long = 0,
        @SerializedName("watched_at")
        override var watchedAt: ZonedDateTime? = null,
        override var action: TraktHistoryActionType = TraktHistoryActionType.UNSPECIFIED,
        override var type: TraktSyncItemType = TraktSyncItemType.UNSPECIFIED,
        override var movie: TraktMovieImpl? = null,
        override var show: TraktShowImpl? = null,
        override var season: TraktSeasonImpl? = null,
        override var episode: TraktEpisodeImpl? = null
) : TraktHistoryItem
