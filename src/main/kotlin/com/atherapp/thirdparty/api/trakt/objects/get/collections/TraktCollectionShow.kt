package com.atherapp.thirdparty.api.trakt.objects.get.collections

import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktCollectionShow : TraktShow {
    var lastCollectedAt: ZonedDateTime?

    var show: TraktShow

    var seasons: MutableList<TraktCollectionShowSeason>

}
