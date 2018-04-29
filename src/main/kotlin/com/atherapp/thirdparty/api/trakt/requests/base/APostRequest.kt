package com.atherapp.thirdparty.api.trakt.requests.base

import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody
import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IPostRequest
import com.atherapp.thirdparty.api.trakt.utils.http.HttpMethod

internal abstract class APostRequest<TRequestBodyType : IRequestBody> : ARequest(), IPostRequest<TRequestBodyType> {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val method: HttpMethod = HttpMethod.POST

    override var requestBody: TRequestBodyType? = null

    override fun validate(variableName: String) { requestBody?.validate(variableName) }
}