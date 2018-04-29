package com.atherapp.thirdparty.api.trakt.objects.get.users

import com.atherapp.thirdparty.api.trakt.enums.TraktHiddenItemType
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktUserHiddenItem {
    var hiddenAt: ZonedDateTime?

    var type: TraktHiddenItemType

    var movie: TraktMovie?

    var show: TraktShow?

    var season: TraktSeason?

}
