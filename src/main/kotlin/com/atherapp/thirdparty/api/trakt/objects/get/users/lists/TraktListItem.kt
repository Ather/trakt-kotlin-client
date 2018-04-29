package com.atherapp.thirdparty.api.trakt.objects.get.users.lists

import com.atherapp.thirdparty.api.trakt.enums.TraktListItemType
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktListItem {
    var rank: String

    var listedAt: ZonedDateTime?

    var type: TraktListItemType

    var movie: TraktMovie?

    var show: TraktShow?

    var season: TraktSeason?

    var episode: TraktEpisode?

    var person: TraktPerson?

}
