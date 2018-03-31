package media.thehoard.thirdparty.api.trakt.requests.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IBodylessPostRequest
import media.thehoard.thirdparty.api.trakt.utils.http.HttpMethod

internal abstract class ABodylessPostRequest : ARequest(), IBodylessPostRequest {
    override val authorizationRequirement: AuthorizationRequirement
        get() = AuthorizationRequirement.Required

    override val method: HttpMethod
        get() = HttpMethod.POST
}
