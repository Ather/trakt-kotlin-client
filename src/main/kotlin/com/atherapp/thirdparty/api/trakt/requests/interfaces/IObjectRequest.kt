package com.atherapp.thirdparty.api.trakt.requests.interfaces

import com.atherapp.thirdparty.api.trakt.requests.base.RequestObjectType

internal interface IObjectRequest {
    val requestObjectType: RequestObjectType
}
