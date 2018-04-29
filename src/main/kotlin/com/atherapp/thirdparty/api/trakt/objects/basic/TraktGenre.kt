package com.atherapp.thirdparty.api.trakt.objects.basic

import com.atherapp.thirdparty.api.trakt.enums.TraktGenreType

interface TraktGenre {
    var name: String

    var slug: String

    var type: TraktGenreType?
}
