package media.thehoard.thirdparty.api.trakt.requests.checkins

import media.thehoard.thirdparty.api.trakt.requests.base.ADeleteRequest
import media.thehoard.thirdparty.api.trakt.requests.base.APostRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

internal class CheckinRequest<TResponseContentType, TRequestBodyType : IRequestBody>(
        override var requestBody: TRequestBodyType? = null
) : APostRequestHasResponse<TResponseContentType, TRequestBodyType>() {

    override val uriTemplate: String = "checkin"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()
}

internal class CheckinsDeleteRequest : ADeleteRequest() {
    override val uriTemplate: String = "checkin"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()

    override fun validate() {}
}