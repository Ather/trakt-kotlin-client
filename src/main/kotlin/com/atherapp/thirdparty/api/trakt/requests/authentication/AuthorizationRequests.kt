package com.atherapp.thirdparty.api.trakt.requests.authentication

import com.atherapp.thirdparty.api.trakt.requests.base.APostRequestHasResponse
import com.atherapp.thirdparty.api.trakt.requests.base.AuthorizationRequirement
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody
import kotlin.reflect.KClass

internal abstract class AbstractAuthorizationRequest<TResponseContentType : Any, TRequestBodyType : IRequestBody>(
        responseContentClass: KClass<TResponseContentType>,
        override var requestBody: TRequestBodyType?
) : APostRequestHasResponse<TResponseContentType, TRequestBodyType>(responseContentClass) {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.NotRequired

    override val uriPathParameters: Map<String, Any>?
        get() = emptyMap()
}

internal class AuthorizationPollRequest