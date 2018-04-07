package media.thehoard.thirdparty.api.trakt.requests.handler

import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IRequest
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IRequestHasResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.util.concurrent.CompletableFuture

internal interface IRequestHandler : IPostRequestHandler, IPutRequestHandler {

    fun executeNoContentRequestAsync(request: IRequest, requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktNoContentResponse>

    fun <TResponseContentType> executeSingleItemRequestAsync(request: IRequestHasResponse<TResponseContentType>, requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktResponse<TResponseContentType>>

    fun <TResponseContentType> executeListRequestAsync(request: IRequestHasResponse<TResponseContentType>, requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktListResponse<TResponseContentType>>

    fun <TResponseContentType> executePagedRequestAsync(request: IRequestHasResponse<TResponseContentType>, requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktPagedResponse<TResponseContentType>>
}
