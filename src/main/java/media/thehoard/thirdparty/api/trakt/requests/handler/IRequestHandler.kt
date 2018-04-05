package media.thehoard.thirdparty.api.trakt.requests.handler

import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IRequest
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IRequestHasResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.util.concurrent.CompletableFuture

internal interface IRequestHandler : IPostRequestHandler, IPutRequestHandler {
    fun executeNoContentRequestAsync(request: IRequest): CompletableFuture<TraktNoContentResponse>

    fun <TResponseContentType> executeSingleItemRequestAsync(request: IRequestHasResponse<TResponseContentType>): CompletableFuture<TraktResponse<TResponseContentType>>

    fun <TResponseContentType> executeListRequestAsync(request: IRequestHasResponse<TResponseContentType>): CompletableFuture<TraktListResponse<TResponseContentType>>

    fun <TResponseContentType> executePagedRequestAsync(request: IRequestHasResponse<TResponseContentType>): CompletableFuture<TraktPagedResponse<TResponseContentType>>
}
