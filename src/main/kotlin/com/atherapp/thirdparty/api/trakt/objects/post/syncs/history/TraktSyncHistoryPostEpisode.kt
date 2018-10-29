package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history

import com.atherapp.thirdparty.api.trakt.core.TraktEpisodeIds
import java.time.ZonedDateTime

interface TraktSyncHistoryPostEpisode {
    var watchedAt: ZonedDateTime?
    var ids: TraktEpisodeIds
}