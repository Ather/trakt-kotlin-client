package com.atherapp.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.enums.TraktHistoryActionType
import com.atherapp.thirdparty.api.trakt.enums.TraktSyncType
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUserWatchingItem
import java.time.ZonedDateTime

data class TraktUserWatchingItemImpl(
        @SerializedName("started_at") override var startedAt: ZonedDateTime? = null,
        @SerializedName("expires_at") override var expiresAt: ZonedDateTime? = null,
        override var action: TraktHistoryActionType = TraktHistoryActionType.UNSPECIFIED,
        override var type: TraktSyncType = TraktSyncType.UNSPECIFIED,
        override var movie: TraktMovie? = TraktMovieImpl(),
        override var show: TraktShow? = TraktShowImpl(),
        override var episode: TraktEpisode? = TraktEpisodeImpl()
) : TraktUserWatchingItem
