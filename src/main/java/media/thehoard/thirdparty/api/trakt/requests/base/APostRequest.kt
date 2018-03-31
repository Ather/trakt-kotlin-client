package media.thehoard.thirdparty.api.trakt.requests.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IPostRequest
import media.thehoard.thirdparty.api.trakt.utils.http.HttpMethod

internal abstract class APostRequest<TRequestBodyType : IRequestBody> : ARequest(), IPostRequest<TRequestBodyType> {
    override val authorizationRequirement: AuthorizationRequirement
        get() = AuthorizationRequirement.Required

    override val method: HttpMethod
        get() = HttpMethod.POST

    override var requestBody: TRequestBodyType? = null

    override fun validate() {
        requestBody?.validate()
    }
}