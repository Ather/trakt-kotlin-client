package media.thehoard.thirdparty.api.trakt.objects.get.episodes

import java.time.Instant
import java.util.Date

interface TraktEpisodeWatchedProgress : TraktEpisodeProgress {
    var lastWatchedAt: Instant?

}
