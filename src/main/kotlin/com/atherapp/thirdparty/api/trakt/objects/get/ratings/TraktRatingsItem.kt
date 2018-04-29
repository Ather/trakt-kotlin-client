package com.atherapp.thirdparty.api.trakt.objects.get.ratings

import com.atherapp.thirdparty.api.trakt.enums.TraktRatingsItemType
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktRatingsItem {
    var ratedAt: ZonedDateTime?

    var rating: Int?

    var type: TraktRatingsItemType

    var movie: TraktMovie?

    var show: TraktShow?

    var season: TraktSeason?

    var episode: TraktEpisode?

}
