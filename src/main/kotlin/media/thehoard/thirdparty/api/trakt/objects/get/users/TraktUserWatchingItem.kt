package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.enums.TraktHistoryActionType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktUserWatchingItem {
    var startedAt: ZonedDateTime?

    var expiresAt: ZonedDateTime?

    var action: TraktHistoryActionType

    var type: TraktSyncType

    var movie: TraktMovie?

    var show: TraktShow?

    var episode: TraktEpisode?

}
