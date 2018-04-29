package com.atherapp.thirdparty.api.trakt.objects.basic

import com.atherapp.thirdparty.api.trakt.enums.TraktSearchResultType
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList

interface TraktSearchResult {
    var type: TraktSearchResultType

    var score: Float?

    var movie: TraktMovie?

    var show: TraktShow?

    var episode: TraktEpisode?

    var person: TraktPerson?

    var list: TraktList?
}
