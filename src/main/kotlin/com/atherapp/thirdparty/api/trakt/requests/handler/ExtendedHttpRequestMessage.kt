package com.atherapp.thirdparty.api.trakt.requests.handler

import com.atherapp.thirdparty.api.trakt.requests.base.RequestObjectType
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Request

internal class ExtendedHttpRequestMessage(
        override val request: Request
) : Fuel.RequestConvertible {
    var objectId: String = ""

    var seasonNumber: Int? = null

    var episodeNumber: Int? = null

    var requestObjectType: RequestObjectType? = null

    var requestBodyJson: String = ""
}
