package com.atherapp.thirdparty.api.trakt.requests.scrobbles

import com.atherapp.thirdparty.api.trakt.requests.base.APostRequestHasResponse
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody
import kotlin.reflect.KClass

internal class ScrobblePauseRequest<TResponseContentType : Any, TRequestBodyType : IRequestBody>(
        override var requestBody: TRequestBodyType?,
        responseContentClass: KClass<TResponseContentType>
) : APostRequestHasResponse<TResponseContentType, TRequestBodyType>(responseContentClass) {
    override val uriTemplate: String = "scrobble/pause"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()
}

internal class ScrobbleStartRequest<TResponseContentType : Any, TRequestBodyType : IRequestBody>(
        override var requestBody: TRequestBodyType?,
        responseContentClass: KClass<TResponseContentType>
) : APostRequestHasResponse<TResponseContentType, TRequestBodyType>(responseContentClass) {
    override val uriTemplate: String = "scrobble/start"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()
}

internal class ScrobbleStopRequest<TResponseContentType : Any, TRequestBodyType : IRequestBody>(
        override var requestBody: TRequestBodyType?,
        responseContentClass: KClass<TResponseContentType>
) : APostRequestHasResponse<TResponseContentType, TRequestBodyType>(responseContentClass) {
    override val uriTemplate: String = "scrobble/stop"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()
}