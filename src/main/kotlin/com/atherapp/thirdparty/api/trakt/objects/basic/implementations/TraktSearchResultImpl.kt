package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.atherapp.thirdparty.api.trakt.enums.TraktSearchResultType
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSearchResult
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList

data class TraktSearchResultImpl(
        override var type: TraktSearchResultType = TraktSearchResultType.UNSPECIFIED,
        override var score: Float? = null,
        override var movie: TraktMovie? = null,
        override var show: TraktShow? = null,
        override var episode: TraktEpisode? = null,
        override var person: TraktPerson? = null,
        override var list: TraktList? = null
) : TraktSearchResult
