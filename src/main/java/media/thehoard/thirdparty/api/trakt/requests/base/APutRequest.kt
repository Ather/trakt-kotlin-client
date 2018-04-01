package media.thehoard.thirdparty.api.trakt.requests.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IPutRequest
import media.thehoard.thirdparty.api.trakt.utils.http.HttpMethod

internal abstract class APutRequest<TRequestBodyType : IRequestBody> : ARequest(), IPutRequest<TRequestBodyType> {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val method: HttpMethod = HttpMethod.PUT

    override var requestBody: TRequestBodyType? = null

    override fun validate() { requestBody?.validate() }
}