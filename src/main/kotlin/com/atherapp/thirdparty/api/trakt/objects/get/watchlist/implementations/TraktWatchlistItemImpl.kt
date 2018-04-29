package com.atherapp.thirdparty.api.trakt.objects.get.watchlist.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.enums.TraktSyncItemType
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import com.atherapp.thirdparty.api.trakt.objects.get.watchlist.TraktWatchlistItem
import java.time.ZonedDateTime

data class TraktWatchlistItemImpl(
        @SerializedName("listed_at") override var listedAt: ZonedDateTime? = null,
        override var type: TraktSyncItemType = TraktSyncItemType.UNSPECIFIED,
        override var movie: TraktMovie? = TraktMovieImpl(),
        override var show: TraktShow? = TraktShowImpl(),
        override var season: TraktSeason? = TraktSeasonImpl(),
        override var episode: TraktEpisode? = TraktEpisodeImpl()
) : TraktWatchlistItem
