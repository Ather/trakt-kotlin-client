package media.thehoard.thirdparty.api.trakt.objects.get.syncs.playback

import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktSyncPlaybackProgressItem {
    var id: Int

    var progress: Float?

    var pausedAt: ZonedDateTime?

    var type: TraktSyncType

    var movie: TraktMovie

    var episode: TraktEpisode

    var show: TraktShow

}
