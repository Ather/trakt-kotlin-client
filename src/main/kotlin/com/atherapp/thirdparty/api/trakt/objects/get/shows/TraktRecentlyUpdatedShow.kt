package com.atherapp.thirdparty.api.trakt.objects.get.shows

import java.time.ZonedDateTime

interface TraktRecentlyUpdatedShow : TraktShow {
    var recentlyUpdatedAt: ZonedDateTime?

    var show: TraktShow
}
