package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities

import java.time.Instant
import java.util.Date

interface TraktSyncEpisodesLastActivities {
    var watchedAt: Instant?

    var collectedAt: Instant?

    var ratedAt: Instant?

    var watchlistedAt: Instant?

    var commentedAt: Instant?

    var pausedAt: Instant?

}
