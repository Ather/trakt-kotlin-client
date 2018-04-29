package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.atherapp.thirdparty.api.trakt.enums.TraktGenreType
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktGenre

data class TraktGenreImpl(
        override var name: String = "",
        override var slug: String = "",
        override var type: TraktGenreType? = null
) : TraktGenre
