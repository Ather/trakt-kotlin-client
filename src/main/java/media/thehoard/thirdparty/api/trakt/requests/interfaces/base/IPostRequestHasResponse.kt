package media.thehoard.thirdparty.api.trakt.requests.interfaces.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface IPostRequestHasResponse<TResponseContentType, TRequestBodyType : IRequestBody> : IRequestHasResponse<TResponseContentType>, IHasRequestBody<TRequestBodyType>
