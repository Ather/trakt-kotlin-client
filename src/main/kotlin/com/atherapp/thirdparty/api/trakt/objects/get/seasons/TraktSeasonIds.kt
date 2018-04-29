package com.atherapp.thirdparty.api.trakt.objects.get.seasons

import com.atherapp.thirdparty.api.trakt.core.TraktDefaultIds

interface TraktSeasonIds : TraktDefaultIds {
    var trakt: Int

    var tvdb: Int?

    var tmdb: Int?

}
