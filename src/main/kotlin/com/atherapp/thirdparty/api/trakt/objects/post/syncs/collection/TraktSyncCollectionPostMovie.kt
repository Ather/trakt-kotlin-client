package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection

import com.atherapp.thirdparty.api.trakt.core.TraktMovieIds
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktMetadata
import java.time.ZonedDateTime

interface TraktSyncCollectionPostMovie {
    var collectedAt: ZonedDateTime?

    var title: String

    var year: Int?

    var ids: TraktMovieIds

    var metadata: TraktMetadata?
}