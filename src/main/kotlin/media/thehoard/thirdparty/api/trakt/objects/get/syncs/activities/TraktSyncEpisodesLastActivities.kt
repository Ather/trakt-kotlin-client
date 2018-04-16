package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities

import java.time.ZonedDateTime

interface TraktSyncEpisodesLastActivities {
    var watchedAt: ZonedDateTime?

    var collectedAt: ZonedDateTime?

    var ratedAt: ZonedDateTime?

    var watchlistedAt: ZonedDateTime?

    var commentedAt: ZonedDateTime?

    var pausedAt: ZonedDateTime?

}
