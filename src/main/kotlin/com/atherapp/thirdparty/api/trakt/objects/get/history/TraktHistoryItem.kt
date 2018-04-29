package com.atherapp.thirdparty.api.trakt.objects.get.history

import com.atherapp.thirdparty.api.trakt.enums.TraktHistoryActionType
import com.atherapp.thirdparty.api.trakt.enums.TraktSyncItemType
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktHistoryItem {
    var id: Long

    var watchedAt: ZonedDateTime?

    var action: TraktHistoryActionType

    var type: TraktSyncItemType

    var movie: TraktMovie?

    var show: TraktShow?

    var season: TraktSeason?

    var episode: TraktEpisode?

}
