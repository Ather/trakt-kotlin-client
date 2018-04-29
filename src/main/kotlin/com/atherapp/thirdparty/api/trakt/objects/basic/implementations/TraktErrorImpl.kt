package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktError

data class TraktErrorImpl(
        override var error: String = "",
        override var description: String = ""
) : TraktError
