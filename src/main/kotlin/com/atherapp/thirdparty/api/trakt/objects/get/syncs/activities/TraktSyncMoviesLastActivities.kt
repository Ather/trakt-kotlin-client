package com.atherapp.thirdparty.api.trakt.objects.get.syncs.activities

import java.time.ZonedDateTime

interface TraktSyncMoviesLastActivities {
    var watchedAt: ZonedDateTime?

    var collectedAt: ZonedDateTime?

    var ratedAt: ZonedDateTime?

    var watchlistedAt: ZonedDateTime?

    var commentedAt: ZonedDateTime?

    var pausedAt: ZonedDateTime?

    var hiddenAt: ZonedDateTime?

}
