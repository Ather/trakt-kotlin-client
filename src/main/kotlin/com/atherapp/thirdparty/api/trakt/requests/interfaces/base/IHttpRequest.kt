package com.atherapp.thirdparty.api.trakt.requests.interfaces.base

import com.atherapp.thirdparty.api.trakt.utils.http.HttpMethod

interface IHttpRequest {
    val method: HttpMethod
}
