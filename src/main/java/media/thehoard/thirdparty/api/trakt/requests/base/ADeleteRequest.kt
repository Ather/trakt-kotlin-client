package media.thehoard.thirdparty.api.trakt.requests.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IDeleteRequest
import media.thehoard.thirdparty.api.trakt.utils.http.HttpMethod

internal abstract class ADeleteRequest : ARequest(), IDeleteRequest {
    override val authorizationRequirement: AuthorizationRequirement
        get() = AuthorizationRequirement.Required

    override val method: HttpMethod
        get() = HttpMethod.DELETE
}
