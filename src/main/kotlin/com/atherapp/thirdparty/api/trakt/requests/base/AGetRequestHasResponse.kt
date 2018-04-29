package com.atherapp.thirdparty.api.trakt.requests.base

import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IGetRequestHasResponse
import com.atherapp.thirdparty.api.trakt.utils.http.HttpMethod
import kotlin.reflect.KClass

internal abstract class AGetRequestHasResponse<TResponseContentType : Any>(responseContentClass: KClass<TResponseContentType>) : ARequestHasResponse<TResponseContentType>(responseContentClass), IGetRequestHasResponse<TResponseContentType> {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.NotRequired

    override val method: HttpMethod = HttpMethod.GET
}