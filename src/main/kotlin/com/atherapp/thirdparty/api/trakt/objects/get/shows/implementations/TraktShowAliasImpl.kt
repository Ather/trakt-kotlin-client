package com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShowAlias

data class TraktShowAliasImpl(
        override var title: String = "",
        override var country: String = ""
) : TraktShowAlias
