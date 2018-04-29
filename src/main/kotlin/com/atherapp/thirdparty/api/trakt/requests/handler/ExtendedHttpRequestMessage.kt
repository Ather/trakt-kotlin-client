package com.atherapp.thirdparty.api.trakt.requests.handler

import com.atherapp.thirdparty.api.trakt.requests.base.RequestObjectType
import com.atherapp.thirdparty.api.trakt.utils.http.HttpMethod
import org.asynchttpclient.RequestBuilder
import org.asynchttpclient.uri.Uri

internal class ExtendedHttpRequestMessage(
        val method: HttpMethod,
        uri: String? = null
) : RequestBuilder(method.toString()) {
    init {
        this.uri = Uri.create(uri)
    }

    var objectId: String = ""

    var seasonNumber: Int? = null

    var episodeNumber: Int? = null

    var url: String = ""

    var requestObjectType: RequestObjectType? = null

    var requestBodyJson: String = ""
}
