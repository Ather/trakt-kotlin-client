package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktShowIds
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostShow
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostShowSeason
import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime

data class TraktSyncHistoryPostShowImpl(
        @SerializedName("watched_at")
        override var watchedAt: ZonedDateTime? = null,
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktShowIds = TraktShowIds(),
        override var seasons: MutableList<TraktSyncHistoryPostShowSeason> = mutableListOf()
) : TraktSyncHistoryPostShow
