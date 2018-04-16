package media.thehoard.thirdparty.api.trakt.responses.interfaces

interface ITraktPagedResponseHeaders : ITraktResponseHeaders {
    var pageCount: Int?

    var itemCount: Int?
}
