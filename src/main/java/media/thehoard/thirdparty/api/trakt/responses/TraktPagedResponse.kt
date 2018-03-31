package media.thehoard.thirdparty.api.trakt.responses

import media.thehoard.thirdparty.api.trakt.responses.interfaces.ITraktPagedResponse

class TraktPagedResponse<TResponseContentType> : TraktListResponse<TResponseContentType>(), ITraktPagedResponse<TResponseContentType> {
    override var pageCount: Int? = null

    override var itemCount: Int? = null

    override fun equals(other: Any?): Boolean {
        if (other is TraktPagedResponse<*>)
            return (super.equals(other) && other.page == page
                    && other.limit == limit
                    && other.pageCount == pageCount
                    && other.itemCount == itemCount)

        return false
    }
}
