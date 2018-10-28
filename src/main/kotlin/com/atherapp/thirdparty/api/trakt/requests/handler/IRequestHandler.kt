package com.atherapp.thirdparty.api.trakt.requests.handler

import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IRequest
import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IRequestHasResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktListResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktPagedResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import kotlinx.coroutines.Deferred

internal interface IRequestHandler : IPostRequestHandler, IPutRequestHandler {

    fun executeNoContentRequestAsync(request: IRequest, requestAuthorization: TraktAuthorization = client.authorization): Deferred<TraktNoContentResponse>

    fun <TResponseContentType : Any> executeSingleItemRequestAsync(request: IRequestHasResponse<TResponseContentType>, requestAuthorization: TraktAuthorization = client.authorization): Deferred<TraktResponse<TResponseContentType>>

    fun <TResponseContentType : Any> executeListRequestAsync(request: IRequestHasResponse<TResponseContentType>, requestAuthorization: TraktAuthorization = client.authorization): Deferred<TraktListResponse<TResponseContentType>>

    fun <TResponseContentType : Any> executePagedRequestAsync(request: IRequestHasResponse<TResponseContentType>, requestAuthorization: TraktAuthorization = client.authorization): Deferred<TraktPagedResponse<TResponseContentType>>
}
