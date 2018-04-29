package com.atherapp.thirdparty.api.trakt.objects.get.people

import com.atherapp.thirdparty.api.trakt.core.TraktDefaultIds

interface TraktPersonIds : TraktDefaultIds {
    var trakt: Int

    var slug: String

    var imdb: String

    var tmdb: Int?

}
