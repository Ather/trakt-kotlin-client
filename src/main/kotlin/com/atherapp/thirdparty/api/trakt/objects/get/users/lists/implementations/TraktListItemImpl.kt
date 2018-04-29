package com.atherapp.thirdparty.api.trakt.objects.get.users.lists.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.enums.TraktListItemType
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson
import com.atherapp.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktListItem
import java.time.ZonedDateTime

data class TraktListItemImpl(
        override var rank: String = "",
        @SerializedName("listed_at") override var listedAt: ZonedDateTime? = null,
        override var type: TraktListItemType = TraktListItemType.UNSPECIFIED,
        override var movie: TraktMovie? = TraktMovieImpl(),
        override var show: TraktShow? = TraktShowImpl(),
        override var season: TraktSeason? = TraktSeasonImpl(),
        override var episode: TraktEpisode? = TraktEpisodeImpl(),
        override var person: TraktPerson? = TraktPersonImpl()
) : TraktListItem
