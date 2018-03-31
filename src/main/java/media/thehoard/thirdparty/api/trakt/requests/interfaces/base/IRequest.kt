package media.thehoard.thirdparty.api.trakt.requests.interfaces.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IValidatable

interface IRequest : IHttpRequest, IHasRequestAuthorization, IHasUri, IValidatable
