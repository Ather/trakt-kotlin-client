package com.atherapp.thirdparty.api.trakt.objects.get.movies

import com.atherapp.thirdparty.api.trakt.core.TraktDefaultIds

interface TraktMovieIds : TraktDefaultIds {
    var trakt: Int

    var slug: String

    var imdb: String

    var tmdb: Int?

}
