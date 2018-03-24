package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktHistoryActionType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserWatchingItem

import java.time.Instant

data class TraktUserWatchingItemImpl(
        @SerializedName("started_at") override var startedAt: Instant? = null,
        @SerializedName("expires_at") override var expiresAt: Instant? = null,
        override var action: TraktHistoryActionType = TraktHistoryActionType.UNSPECIFIED,
        override var type: TraktSyncType = TraktSyncType.UNSPECIFIED,
        override var movie: TraktMovieImpl = TraktMovieImpl(),
        override var show: TraktShowImpl = TraktShowImpl(),
        override var episode: TraktEpisodeImpl = TraktEpisodeImpl()
) : TraktUserWatchingItem
