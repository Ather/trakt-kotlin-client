package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktImage

data class TraktImageImpl(
        override var full: String = ""
) : TraktImage
