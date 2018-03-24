package media.thehoard.thirdparty.api.trakt.objects.get.watchlist.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncItemType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watchlist.TraktWatchlistItem

import java.time.Instant

data class TraktWatchlistItemImpl(
        @SerializedName("listed_at") override var listedAt: Instant? = null,
        override var type: TraktSyncItemType = TraktSyncItemType.UNSPECIFIED,
        override var movie: TraktMovieImpl = TraktMovieImpl(),
        override var show: TraktShowImpl = TraktShowImpl(),
        override var season: TraktSeasonImpl = TraktSeasonImpl(),
        override var episode: TraktEpisodeImpl = TraktEpisodeImpl()
) : TraktWatchlistItem
