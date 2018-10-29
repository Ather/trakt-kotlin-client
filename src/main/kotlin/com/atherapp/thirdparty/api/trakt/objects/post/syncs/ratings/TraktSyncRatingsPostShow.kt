package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings

import com.atherapp.thirdparty.api.trakt.core.TraktShowIds
import java.time.ZonedDateTime

interface TraktSyncRatingsPostShow {
    var title: String
    var year: Int?
    var ids: TraktShowIds
    var rating: Int?
    var ratedAt: ZonedDateTime?
    var seasons: MutableList<TraktSyncRatingsPostShowSeason>
}