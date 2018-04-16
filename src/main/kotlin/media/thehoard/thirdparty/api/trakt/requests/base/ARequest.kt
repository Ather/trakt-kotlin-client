package media.thehoard.thirdparty.api.trakt.requests.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IRequest
import media.thehoard.thirdparty.api.trakt.utils.http.HttpMethod

internal abstract class ARequest : IRequest {
    abstract override val authorizationRequirement: AuthorizationRequirement

    abstract override val method: HttpMethod

    abstract override val uriTemplate: String

    abstract override val uriPathParameters: Map<String, Any>?

    abstract override fun validate(variableName: String)
}