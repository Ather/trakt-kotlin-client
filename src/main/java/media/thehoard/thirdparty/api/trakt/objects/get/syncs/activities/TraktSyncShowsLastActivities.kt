package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities

import java.time.Instant
import java.util.Date

interface TraktSyncShowsLastActivities {
    var ratedAt: Instant?

    var watchlistedAt: Instant?

    var commentedAt: Instant?

    var hiddenAt: Instant?

}
