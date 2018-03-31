package media.thehoard.thirdparty.api.trakt.requests.interfaces.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface IPostRequest<TRequestBodyType : IRequestBody> : IRequest, IHasRequestBody<TRequestBodyType>
