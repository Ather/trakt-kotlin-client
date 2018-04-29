package com.atherapp.thirdparty.api.trakt.objects.get.ratings.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.enums.TraktRatingsItemType
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.ratings.TraktRatingsItem
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

data class TraktRatingsItemImpl(
        @SerializedName("rated_at")
        override var ratedAt: ZonedDateTime? = null,
        override var rating: Int? = null,
        override var type: TraktRatingsItemType = TraktRatingsItemType.UNSPECIFIED,
        override var movie: TraktMovie? = null,
        override var show: TraktShow? = null,
        override var season: TraktSeason? = null,
        override var episode: TraktEpisode? = null
) : TraktRatingsItem
