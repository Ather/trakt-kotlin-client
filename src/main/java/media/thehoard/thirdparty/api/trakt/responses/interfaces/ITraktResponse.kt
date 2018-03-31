package media.thehoard.thirdparty.api.trakt.responses.interfaces

interface ITraktResponse<out TResponseContentType> : ITraktNoContentResponse, ITraktResponseHeaders {
    var hasValue: Boolean

    val value: TResponseContentType?
}
