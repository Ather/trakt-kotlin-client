package com.atherapp.thirdparty.api.trakt.requests.base

import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody
import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IPutRequestHasResponse
import com.atherapp.thirdparty.api.trakt.utils.http.HttpMethod
import kotlin.reflect.KClass

internal abstract class APutRequestHasResponse<TResponseContentType : Any, TRequestBodyType : IRequestBody>(responseContentClass: KClass<TResponseContentType>) : ARequestHasResponse<TResponseContentType>(responseContentClass), IPutRequestHasResponse<TResponseContentType, TRequestBodyType> {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val method: HttpMethod = HttpMethod.PUT

    override var requestBody: TRequestBodyType? = null

    override fun validate(variableName: String) { requestBody?.validate(variableName) }
}