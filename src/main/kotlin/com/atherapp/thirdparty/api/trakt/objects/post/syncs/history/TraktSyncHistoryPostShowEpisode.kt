package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history

import java.time.ZonedDateTime

interface TraktSyncHistoryPostShowEpisode {
    var watchedAt: ZonedDateTime?
    var number: Int
}