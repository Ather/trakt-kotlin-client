package media.thehoard.thirdparty.api.trakt.responses

import media.thehoard.thirdparty.api.trakt.enums.TraktListSortBy
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortHow
import media.thehoard.thirdparty.api.trakt.responses.interfaces.ITraktResponse
import java.time.ZonedDateTime
import kotlin.reflect.KClass

open class TraktResponse<TResponseContentType>(val responseContentClass: KClass<*>) : TraktNoContentResponse(), ITraktResponse<TResponseContentType> {
    override var hasValue: Boolean = false
    override var value: TResponseContentType? = null
    override var sortBy: TraktListSortBy = TraktListSortBy.UNSPECIFIED
    override var sortHow: TraktListSortHow = TraktListSortHow.UNSPECIFIED
    override var startDate: ZonedDateTime? = null
    override var endDate: ZonedDateTime? = null
    override var trendingUserCount: Int? = null
    override var page: Int? = null
    override var limit: Int? = null
    override var isPrivateUser: Boolean? = null
    override var xItemId: Int? = null
    override var xItemType: String = ""

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TraktResponse<*>) return false
        if (!super.equals(other)) return false

        if (hasValue != other.hasValue) return false
        if (value != other.value) return false
        if (sortBy != other.sortBy) return false
        if (sortHow != other.sortHow) return false
        if (startDate != other.startDate) return false
        if (endDate != other.endDate) return false
        if (trendingUserCount != other.trendingUserCount) return false
        if (page != other.page) return false
        if (limit != other.limit) return false
        if (isPrivateUser != other.isPrivateUser) return false
        if (xItemId != other.xItemId) return false
        if (xItemType != other.xItemType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + hasValue.hashCode()
        result = 31 * result + (value?.hashCode() ?: 0)
        result = 31 * result + sortBy.hashCode()
        result = 31 * result + sortHow.hashCode()
        result = 31 * result + (startDate?.hashCode() ?: 0)
        result = 31 * result + (endDate?.hashCode() ?: 0)
        result = 31 * result + (trendingUserCount ?: 0)
        result = 31 * result + (page ?: 0)
        result = 31 * result + (limit ?: 0)
        result = 31 * result + (isPrivateUser?.hashCode() ?: 0)
        result = 31 * result + (xItemId ?: 0)
        result = 31 * result + xItemType.hashCode()
        return result
    }
}
