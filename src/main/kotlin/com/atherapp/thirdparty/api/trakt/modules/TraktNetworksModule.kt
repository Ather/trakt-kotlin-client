package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktNetwork
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.requests.networks.NetworksRequest
import com.atherapp.thirdparty.api.trakt.responses.TraktListResponse
import kotlinx.coroutines.Deferred

class TraktNetworksModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getNetworksAsync(requestAuthorization: TraktAuthorization = client.authorization): Deferred<TraktListResponse<TraktNetwork>> {
        return RequestHandler(client).executeListRequestAsync(NetworksRequest(), requestAuthorization)
    }
}
