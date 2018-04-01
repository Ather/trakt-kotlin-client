package media.thehoard.thirdparty.api.trakt.requests.handler

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IPostRequest
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IPostRequestHasResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.util.concurrent.CompletableFuture

interface IPostRequestHandler {
    fun <TRequestBodyType : IRequestBody> executeNoContentRequest(request: IPostRequest<TRequestBodyType>): CompletableFuture<TraktNoContentResponse>

    fun <TResponseContentType, TRequestBodyType : IRequestBody> executeSingleItemRequest(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>): CompletableFuture<TraktResponse<TResponseContentType>>

    fun <TResponseContentType, TRequestBodyType : IRequestBody> executeListRequest(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>): CompletableFuture<TraktListResponse<TResponseContentType>>

    fun <TResponseContentType, TRequestBodyType : IRequestBody> executePagedRequest(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>): CompletableFuture<TraktPagedResponse<TResponseContentType>>
}
