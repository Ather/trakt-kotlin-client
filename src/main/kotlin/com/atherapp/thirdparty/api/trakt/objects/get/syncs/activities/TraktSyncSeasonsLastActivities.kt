package com.atherapp.thirdparty.api.trakt.objects.get.syncs.activities

import java.time.ZonedDateTime

interface TraktSyncSeasonsLastActivities {
    var ratedAt: ZonedDateTime?

    var watchlistedAt: ZonedDateTime?

    var commentedAt: ZonedDateTime?

    var hiddenAt: ZonedDateTime?

}
