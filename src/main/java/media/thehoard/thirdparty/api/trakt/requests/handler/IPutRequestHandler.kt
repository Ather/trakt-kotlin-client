package media.thehoard.thirdparty.api.trakt.requests.handler

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IPutRequest
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IPutRequestHasResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.util.concurrent.CompletableFuture

interface IPutRequestHandler {
    fun <TRequestBodyType : IRequestBody> executeNoContentRequest(request: IPutRequest<TRequestBodyType>): CompletableFuture<TraktNoContentResponse>

    fun <TResponseContentType, TRequestBodyType : IRequestBody> executeSingleItemRequest(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>): CompletableFuture<TraktResponse<TResponseContentType>>

    fun <TResponseContentType, TRequestBodyType : IRequestBody> executeListRequest(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>): CompletableFuture<TraktListResponse<TResponseContentType>>

    fun <TResponseContentType, TRequestBodyType : IRequestBody> executePagedRequest(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>): CompletableFuture<TraktPagedResponse<TResponseContentType>>
}
