package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktEpisodeIds
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostEpisode
import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime

data class TraktSyncHistoryPostEpisodeImpl(
        @SerializedName("watched_at") override var watchedAt: ZonedDateTime? = null,
        override var ids: TraktEpisodeIds = TraktEpisodeIds()
) : TraktSyncHistoryPostEpisode
