package media.thehoard.thirdparty.api.trakt.requests.interfaces.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface IPutRequestHasResponse<TResponseContentType, TRequestBodyType : IRequestBody> : IRequestHasResponse<TResponseContentType>, IHasRequestBody<TRequestBodyType>
