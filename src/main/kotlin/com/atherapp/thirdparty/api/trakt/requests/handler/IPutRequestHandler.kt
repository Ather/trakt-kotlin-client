package com.atherapp.thirdparty.api.trakt.requests.handler

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody
import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IPutRequest
import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IPutRequestHasResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktListResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktPagedResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import java.util.concurrent.CompletableFuture

internal interface IPutRequestHandler {
    val client: TraktClient

    fun <TRequestBodyType : IRequestBody> executeNoContentRequestAsync(request: IPutRequest<TRequestBodyType>, requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktNoContentResponse>

    fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executeSingleItemRequestAsync(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktResponse<TResponseContentType>>

    fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executeListRequestAsync(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktListResponse<TResponseContentType>>

    fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executePagedRequestAsync(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktPagedResponse<TResponseContentType>>
}
