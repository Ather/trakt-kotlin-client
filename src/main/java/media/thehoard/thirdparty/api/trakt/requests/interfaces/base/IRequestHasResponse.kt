package media.thehoard.thirdparty.api.trakt.requests.interfaces.base

import kotlin.reflect.KClass

internal interface IRequestHasResponse<TResponseContentType> : IRequest {
    val responseContentClass: KClass<*>
}
