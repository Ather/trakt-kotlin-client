package media.thehoard.thirdparty.api.trakt.requests.interfaces.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface IPutRequest<TRequestBodyType : IRequestBody> : IRequest, IHasRequestBody<TRequestBodyType>
