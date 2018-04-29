package com.atherapp.thirdparty.api.trakt.objects.get.episodes

import com.atherapp.thirdparty.api.trakt.core.TraktDefaultIds

interface TraktEpisodeIds : TraktDefaultIds {
    var trakt: Int

    var tvdb: Int?

    var imdb: String

    var tmdb: Int?
}
