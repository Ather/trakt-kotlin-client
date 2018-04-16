package media.thehoard.thirdparty.api.trakt.objects.get.history

import media.thehoard.thirdparty.api.trakt.enums.TraktHistoryActionType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncItemType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktHistoryItem {
    var id: Long

    var watchedAt: ZonedDateTime?

    var action: TraktHistoryActionType

    var type: TraktSyncItemType

    var movie: TraktMovie?

    var show: TraktShow?

    var season: TraktSeason?

    var episode: TraktEpisode?

}
