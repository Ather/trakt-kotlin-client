package com.atherapp.thirdparty.api.trakt.requests.base

import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IDeleteRequest
import com.atherapp.thirdparty.api.trakt.utils.http.HttpMethod

internal abstract class ADeleteRequest : ARequest(), IDeleteRequest {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val method: HttpMethod = HttpMethod.DELETE
}
