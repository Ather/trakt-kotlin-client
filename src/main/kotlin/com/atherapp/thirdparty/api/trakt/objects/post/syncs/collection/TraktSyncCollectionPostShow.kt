package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection

import com.atherapp.thirdparty.api.trakt.core.TraktShowIds
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktMetadata
import java.time.ZonedDateTime

interface TraktSyncCollectionPostShow {
    var collectedAt: ZonedDateTime?

    var title: String

    var year: Int?

    var ids: TraktShowIds

    var metadata: TraktMetadata?

    var seasons: MutableList<TraktSyncCollectionPostShowSeason>
}