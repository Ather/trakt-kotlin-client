package com.atherapp.thirdparty.api.trakt.requests.handler

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody
import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IPostRequest
import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IPostRequestHasResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktListResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktPagedResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import kotlinx.coroutines.Deferred

internal interface IPostRequestHandler {
    val client: TraktClient

    fun <TRequestBodyType : IRequestBody> executeNoContentRequestAsync(request: IPostRequest<TRequestBodyType>, requestAuthorization: TraktAuthorization = client.authorization): Deferred<TraktNoContentResponse>

    fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executeSingleItemRequestAsync(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization = client.authorization): Deferred<TraktResponse<TResponseContentType>>

    fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executeListRequestAsync(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization = client.authorization): Deferred<TraktListResponse<TResponseContentType>>

    fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executePagedRequestAsync(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization = client.authorization): Deferred<TraktPagedResponse<TResponseContentType>>
}
