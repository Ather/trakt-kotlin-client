package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktMetadata
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds
import java.time.ZonedDateTime

interface TraktSyncCollectionPostEpisode {
    var collectedAt: ZonedDateTime?

    var ids: TraktEpisodeIds

    var metadata: TraktMetadata?
}