package media.thehoard.thirdparty.api.trakt.objects.get.syncs.playback

import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

import java.time.Instant

interface TraktSyncPlaybackProgressItem {
    var id: Int

    var progress: Float?

    var pausedAt: Instant?

    var type: TraktSyncType

    var movie: TraktMovieImpl

    var episode: TraktEpisodeImpl

    var show: TraktShowImpl

}
