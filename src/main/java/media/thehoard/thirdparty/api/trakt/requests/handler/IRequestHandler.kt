package media.thehoard.thirdparty.api.trakt.requests.handler

import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IRequest
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IRequestHasResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse

interface IRequestHandler : IPostRequestHandler, IPutRequestHandler {
    fun executeNoContentRequest(request: IRequest): TraktNoContentResponse

    fun <TResponseContentType> executeSingleItemRequest(request: IRequestHasResponse<TResponseContentType>): TraktResponse<TResponseContentType>

    fun <TResponseContentType> executeListRequest(request: IRequestHasResponse<TResponseContentType>): TraktListResponse<TResponseContentType>

    fun <TResponseContentType> executePagedRequest(request: IRequestHasResponse<TResponseContentType>): TraktPagedResponse<TResponseContentType>
}
