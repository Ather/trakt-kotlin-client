package com.atherapp.thirdparty.api.trakt.requests.base

import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IBodylessPostRequest
import com.atherapp.thirdparty.api.trakt.utils.http.HttpMethod

internal abstract class ABodylessPostRequest : ARequest(), IBodylessPostRequest {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val method: HttpMethod = HttpMethod.POST
}
