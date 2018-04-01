package media.thehoard.thirdparty.api.trakt.requests.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IGetRequestHasResponse
import media.thehoard.thirdparty.api.trakt.utils.http.HttpMethod

internal abstract class AGetRequestHasResponse<TResponseContentType> : ARequestHasResponse<TResponseContentType>(), IGetRequestHasResponse<TResponseContentType> {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.NotRequired

    override val method: HttpMethod = HttpMethod.GET
}