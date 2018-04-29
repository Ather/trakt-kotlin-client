package com.atherapp.thirdparty.api.trakt.objects.get.watchlist

import com.atherapp.thirdparty.api.trakt.enums.TraktSyncItemType
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktWatchlistItem {
    var listedAt: ZonedDateTime?

    var type: TraktSyncItemType

    var movie: TraktMovie?

    var show: TraktShow?

    var season: TraktSeason?

    var episode: TraktEpisode?

}
