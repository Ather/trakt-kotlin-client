package media.thehoard.thirdparty.api.trakt.requests.handler

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IPutRequest
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IPutRequestHasResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.util.concurrent.CompletableFuture

internal interface IPutRequestHandler {
    val client: TraktClient

    fun <TRequestBodyType : IRequestBody> executeNoContentRequestAsync(request: IPutRequest<TRequestBodyType>, requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktNoContentResponse>

    fun <TResponseContentType, TRequestBodyType : IRequestBody> executeSingleItemRequestAsync(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktResponse<TResponseContentType>>

    fun <TResponseContentType, TRequestBodyType : IRequestBody> executeListRequestAsync(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktListResponse<TResponseContentType>>

    fun <TResponseContentType, TRequestBodyType : IRequestBody> executePagedRequestAsync(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktPagedResponse<TResponseContentType>>
}
