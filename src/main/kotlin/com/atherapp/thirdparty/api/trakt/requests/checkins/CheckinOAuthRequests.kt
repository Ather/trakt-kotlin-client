package com.atherapp.thirdparty.api.trakt.requests.checkins

import com.atherapp.thirdparty.api.trakt.requests.base.ADeleteRequest
import com.atherapp.thirdparty.api.trakt.requests.base.APostRequestHasResponse
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody
import kotlin.reflect.KClass

internal class CheckinRequest<TResponseContentType : Any, TRequestBodyType : IRequestBody>(
        override var requestBody: TRequestBodyType? = null,
        responseContentClass: KClass<TResponseContentType>
) : APostRequestHasResponse<TResponseContentType, TRequestBodyType>(responseContentClass) {

    override val uriTemplate: String = "checkin"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()
}

internal class CheckinsDeleteRequest : ADeleteRequest() {
    override val uriTemplate: String = "checkin"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()

    override fun validate(variableName: String) {}
}