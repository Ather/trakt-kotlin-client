package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovieIds
import java.time.ZonedDateTime

interface TraktSyncRatingsPostMovie {
    var title: String
    var year: Int?
    var ids: TraktMovieIds
    var rating: Int?
    var ratedAt: ZonedDateTime?
}