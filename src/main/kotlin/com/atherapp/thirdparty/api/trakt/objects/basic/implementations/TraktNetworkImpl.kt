package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktNetwork

data class TraktNetworkImpl(
        override var network: String = ""
) : TraktNetwork
