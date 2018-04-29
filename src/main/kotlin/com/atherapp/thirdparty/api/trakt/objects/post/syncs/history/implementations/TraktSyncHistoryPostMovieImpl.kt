package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovieIds
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostMovie
import java.time.ZonedDateTime

data class TraktSyncHistoryPostMovieImpl(
        @SerializedName("watched_at") override var watchedAt: ZonedDateTime? = null,
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktMovieIds = TraktMovieIdsImpl()
) : TraktSyncHistoryPostMovie
