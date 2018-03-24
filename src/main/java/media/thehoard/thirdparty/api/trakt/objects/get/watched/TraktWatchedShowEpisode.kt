package media.thehoard.thirdparty.api.trakt.objects.get.watched

import java.time.Instant
import java.util.Date

interface TraktWatchedShowEpisode {
    var number: Int?

    var plays: Int?

    var lastWatchedAt: Instant?

}
