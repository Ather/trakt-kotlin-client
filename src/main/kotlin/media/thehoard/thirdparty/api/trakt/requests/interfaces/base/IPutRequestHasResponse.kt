package media.thehoard.thirdparty.api.trakt.requests.interfaces.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

internal interface IPutRequestHasResponse<TResponseContentType : Any, TRequestBodyType : IRequestBody> : IRequestHasResponse<TResponseContentType>, IHasRequestBody<TRequestBodyType>
