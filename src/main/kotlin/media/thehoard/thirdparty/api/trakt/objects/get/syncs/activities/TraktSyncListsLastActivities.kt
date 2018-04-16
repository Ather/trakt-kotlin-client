package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities

import java.time.ZonedDateTime

interface TraktSyncListsLastActivities {
    var likedAt: ZonedDateTime?

    var updatedAt: ZonedDateTime?

    var commentedAt: ZonedDateTime?

}
