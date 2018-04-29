package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktRating

data class TraktRatingImpl(
        override var rating: Float? = null,
        override var votes: Int? = null,
        override var distribution: Map<String, Int> = mapOf()
) : TraktRating
