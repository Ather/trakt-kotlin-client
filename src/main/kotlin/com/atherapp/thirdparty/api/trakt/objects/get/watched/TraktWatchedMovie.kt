package com.atherapp.thirdparty.api.trakt.objects.get.watched

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import java.time.ZonedDateTime

interface TraktWatchedMovie {
    var plays: Int?

    var lastWatchedAt: ZonedDateTime?

    var movie: TraktMovie

}
