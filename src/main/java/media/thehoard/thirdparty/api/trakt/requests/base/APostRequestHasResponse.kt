package media.thehoard.thirdparty.api.trakt.requests.base

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IPostRequestHasResponse
import media.thehoard.thirdparty.api.trakt.utils.http.HttpMethod
import kotlin.reflect.KClass

internal abstract class APostRequestHasResponse<TResponseContentType, TRequestBodyType : IRequestBody>(responseContentClass: KClass<*>) : ARequestHasResponse<TResponseContentType>(responseContentClass), IPostRequestHasResponse<TResponseContentType, TRequestBodyType> {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val method: HttpMethod = HttpMethod.POST

    override var requestBody: TRequestBodyType? = null

    override fun validate() { requestBody?.validate() }
}