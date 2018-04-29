package com.atherapp.thirdparty.api.trakt.objects.get.collections

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktMetadata
import java.time.ZonedDateTime

interface TraktCollectionShowEpisode {
    var number: Int?

    var collectedAt: ZonedDateTime?

    var metadata: TraktMetadata?
}
