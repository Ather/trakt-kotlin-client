package media.thehoard.thirdparty.api.trakt.objects.get.watchlist

import media.thehoard.thirdparty.api.trakt.enums.TraktSyncItemType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

interface TraktWatchlistItem {
    var listedAt: ZonedDateTime?

    var type: TraktSyncItemType

    var movie: TraktMovieImpl

    var show: TraktShowImpl

    var season: TraktSeasonImpl

    var episode: TraktEpisodeImpl

}
