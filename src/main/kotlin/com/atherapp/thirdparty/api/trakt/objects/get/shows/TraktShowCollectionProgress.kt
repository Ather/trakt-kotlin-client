package com.atherapp.thirdparty.api.trakt.objects.get.shows

import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeasonCollectionProgress
import java.time.ZonedDateTime

interface TraktShowCollectionProgress : TraktShowProgress {
    var lastCollectedAt: ZonedDateTime?

    var seasons: MutableList<TraktSeasonCollectionProgress>
}