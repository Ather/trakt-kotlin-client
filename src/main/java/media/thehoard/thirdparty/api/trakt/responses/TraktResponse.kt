package media.thehoard.thirdparty.api.trakt.responses

import media.thehoard.thirdparty.api.trakt.responses.interfaces.ITraktResponse

import java.time.Instant

open class TraktResponse<TResponseContentType> : TraktNoContentResponse(), ITraktResponse<TResponseContentType> {
    override var hasValue: Boolean = false
    override var value: TResponseContentType? = null
    override var sortBy: String = ""
    override var sortHow: String = ""
    override var startDate: Instant? = null
    override var endDate: Instant? = null
    override var trendingUserCount: Int? = null
    override var page: Int? = null
    override var limit: Int? = null
    override var isPrivateUser: Boolean? = null
    override var xItemId: Int? = null
    override var xItemType: String = ""


    override fun equals(other: Any?): Boolean {
        if (other is TraktResponse<*>)
            return (super.equals(other) && other.hasValue == hasValue
                    && other.value == value
                    && other.sortBy == sortBy
                    && other.sortHow == sortHow
                    && other.startDate == startDate
                    && other.endDate == endDate
                    && other.trendingUserCount == trendingUserCount
                    && other.page == page
                    && other.limit == limit
                    && other.isPrivateUser == isPrivateUser)

        return false
    }
}
