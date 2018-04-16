package media.thehoard.thirdparty.api.trakt.objects.get.episodes

import java.time.ZonedDateTime

interface TraktEpisodeWatchedProgress : TraktEpisodeProgress {
    var lastWatchedAt: ZonedDateTime?

}
