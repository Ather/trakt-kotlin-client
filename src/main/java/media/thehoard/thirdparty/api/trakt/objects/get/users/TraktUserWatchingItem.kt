package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.enums.TraktHistoryActionType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

import java.time.Instant

interface TraktUserWatchingItem {
    var startedAt: Instant?

    var expiresAt: Instant?

    var action: TraktHistoryActionType

    var type: TraktSyncType

    var movie: TraktMovieImpl

    var show: TraktShowImpl

    var episode: TraktEpisodeImpl

}
