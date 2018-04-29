package com.atherapp.thirdparty.api.trakt.objects.get.shows

import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeasonWatchedProgress
import java.time.ZonedDateTime

interface TraktShowWatchedProgress : TraktShowProgress {
    var lastWatchedAt: ZonedDateTime?

    var seasons: MutableList<TraktSeasonWatchedProgress>
}
