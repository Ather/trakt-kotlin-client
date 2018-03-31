package media.thehoard.thirdparty.api.trakt.requests.handler

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IPutRequest
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IPutRequestHasResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse

interface IPutRequestHandler {
    fun <TRequestBodyType : IRequestBody> executeNoContentRequest(request: IPutRequest<TRequestBodyType>): TraktNoContentResponse

    fun <TResponseContentType, TRequestBodyType : IRequestBody> executeSingleItemRequest(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>): TraktResponse<TResponseContentType>

    fun <TResponseContentType, TRequestBodyType : IRequestBody> executeListRequest(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>): TraktListResponse<TResponseContentType>

    fun <TResponseContentType, TRequestBodyType : IRequestBody> executePagedRequest(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>): TraktPagedResponse<TResponseContentType>
}
