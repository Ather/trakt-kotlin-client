package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient

interface TraktModule {
    val client: TraktClient
}
