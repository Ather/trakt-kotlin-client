package com.atherapp.thirdparty.api.trakt.objects.get.watched

import java.time.ZonedDateTime

interface TraktWatchedShowEpisode {
    var number: Int?

    var plays: Int?

    var lastWatchedAt: ZonedDateTime?

}
