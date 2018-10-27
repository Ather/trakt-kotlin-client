package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.requests.lists.ListsPopularRequest
import com.atherapp.thirdparty.api.trakt.requests.lists.ListsTrendingRequest
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import com.atherapp.thirdparty.api.trakt.responses.TraktPagedResponse
import java.util.concurrent.CompletableFuture

class TraktListsModule(override val client: TraktClient) : TraktModule {
    fun getPopularListsAsync(
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktList>> {
        return RequestHandler(client).executePagedRequestAsync(ListsPopularRequest(pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getTrendingListsAsync(
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktList>> {
        return RequestHandler(client).executePagedRequestAsync(ListsTrendingRequest(pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }
}