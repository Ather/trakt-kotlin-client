package com.atherapp.thirdparty.api.trakt.objects.get.syncs.activities

import java.time.ZonedDateTime

interface TraktSyncShowsLastActivities {
    var ratedAt: ZonedDateTime?

    var watchlistedAt: ZonedDateTime?

    var commentedAt: ZonedDateTime?

    var hiddenAt: ZonedDateTime?

}
