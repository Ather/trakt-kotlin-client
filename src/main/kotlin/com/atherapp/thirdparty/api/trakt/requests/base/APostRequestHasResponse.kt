package com.atherapp.thirdparty.api.trakt.requests.base

import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody
import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IPostRequestHasResponse
import com.atherapp.thirdparty.api.trakt.utils.http.HttpMethod
import kotlin.reflect.KClass

internal abstract class APostRequestHasResponse<TResponseContentType : Any, TRequestBodyType : IRequestBody>(responseContentClass: KClass<TResponseContentType>) : ARequestHasResponse<TResponseContentType>(responseContentClass), IPostRequestHasResponse<TResponseContentType, TRequestBodyType> {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val method: HttpMethod = HttpMethod.POST

    abstract override var requestBody: TRequestBodyType?

    override fun validate(variableName: String) { requestBody?.validate(variableName) }
}