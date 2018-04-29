package com.atherapp.thirdparty.api.trakt.requests.networks

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktNetwork
import com.atherapp.thirdparty.api.trakt.requests.base.AGetRequestHasResponse

internal class NetworksRequest : AGetRequestHasResponse<TraktNetwork>(TraktNetwork::class) {
    override val uriTemplate: String = "networks"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()

    override fun validate(variableName: String) {}
}