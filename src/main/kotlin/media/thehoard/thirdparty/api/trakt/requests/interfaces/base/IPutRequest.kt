package media.thehoard.thirdparty.api.trakt.requests.interfaces.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

internal interface IPutRequest<TRequestBodyType : IRequestBody> : IRequest, IHasRequestBody<TRequestBodyType>
