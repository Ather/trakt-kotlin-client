package com.atherapp.thirdparty.api.trakt.requests.interfaces.base

import kotlin.reflect.KClass

internal interface IRequestHasResponse<TResponseContentType : Any> : IRequest {
    val responseContentClass: KClass<TResponseContentType>
}
