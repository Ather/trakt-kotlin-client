package media.thehoard.thirdparty.api.trakt.requests.checkins

import media.thehoard.thirdparty.api.trakt.requests.base.ADeleteRequest
import media.thehoard.thirdparty.api.trakt.requests.base.APostRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

internal class CheckinRequest<TResponseContentType, TRequestBodyType : IRequestBody> : APostRequestHasResponse<TResponseContentType, TRequestBodyType>() {
    override var requestBody: TRequestBodyType? = null

    override val uriTemplate: String
        get() = "checkin"

    override val uriPathParameters: Map<String, Any>? = mapOf()
}

internal class CheckinsDeleteRequest : ADeleteRequest() {
    override val uriTemplate: String
        get() = "checkin"

    override val uriPathParameters: Map<String, Any>? = mapOf()

    override fun validate() {}
}