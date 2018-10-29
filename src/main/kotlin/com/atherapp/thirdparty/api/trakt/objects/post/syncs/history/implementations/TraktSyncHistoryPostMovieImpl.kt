package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktMovieIds
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostMovie
import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime

data class TraktSyncHistoryPostMovieImpl(
        @SerializedName("watched_at") override var watchedAt: ZonedDateTime? = null,
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktMovieIds = TraktMovieIds()
) : TraktSyncHistoryPostMovie
