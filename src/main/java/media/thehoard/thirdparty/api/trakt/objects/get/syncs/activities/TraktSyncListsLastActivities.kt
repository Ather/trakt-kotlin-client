package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities

import java.time.Instant
import java.util.Date

interface TraktSyncListsLastActivities {
    var likedAt: Instant?

    var updatedAt: Instant?

    var commentedAt: Instant?

}
