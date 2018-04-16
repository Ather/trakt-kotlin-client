package media.thehoard.thirdparty.api.trakt.requests.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IBodylessPostRequestHasResponse
import media.thehoard.thirdparty.api.trakt.utils.http.HttpMethod
import kotlin.reflect.KClass

internal abstract class ABodylessPostRequestHasResponse<TResponseContentType : Any>(responseContentClass: KClass<TResponseContentType>) : ARequestHasResponse<TResponseContentType>(responseContentClass), IBodylessPostRequestHasResponse<TResponseContentType> {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val method: HttpMethod = HttpMethod.POST
}
