package media.thehoard.thirdparty.api.trakt.requests.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IBodylessPostRequestHasResponse
import media.thehoard.thirdparty.api.trakt.utils.http.HttpMethod

internal abstract class ABodylessPostRequestHasResponse<TResponseContentType> : ARequestHasResponse<TResponseContentType>(), IBodylessPostRequestHasResponse<TResponseContentType> {
    override val authorizationRequirement: AuthorizationRequirement
        get() = AuthorizationRequirement.Required

    override val method: HttpMethod
        get() = HttpMethod.POST
}
