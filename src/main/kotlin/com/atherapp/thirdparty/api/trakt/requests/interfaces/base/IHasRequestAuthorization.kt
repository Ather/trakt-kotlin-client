package com.atherapp.thirdparty.api.trakt.requests.interfaces.base

import com.atherapp.thirdparty.api.trakt.requests.base.AuthorizationRequirement

internal interface IHasRequestAuthorization {
    val authorizationRequirement: AuthorizationRequirement
}
