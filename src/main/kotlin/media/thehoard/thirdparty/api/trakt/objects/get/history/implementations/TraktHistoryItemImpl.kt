package media.thehoard.thirdparty.api.trakt.objects.get.history.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktHistoryActionType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncItemType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.history.TraktHistoryItem
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

data class TraktHistoryItemImpl(
        override var id: Long = 0,
        @SerializedName("watched_at")
        override var watchedAt: ZonedDateTime? = null,
        override var action: TraktHistoryActionType = TraktHistoryActionType.UNSPECIFIED,
        override var type: TraktSyncItemType = TraktSyncItemType.UNSPECIFIED,
        override var movie: TraktMovie? = null,
        override var show: TraktShow? = null,
        override var season: TraktSeason? = null,
        override var episode: TraktEpisode? = null
) : TraktHistoryItem
