package media.thehoard.thirdparty.api.trakt.responses.interfaces

import media.thehoard.thirdparty.api.trakt.enums.TraktListSortBy
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortHow
import java.time.ZonedDateTime

interface ITraktResponseHeaders {
    var sortBy: TraktListSortBy

    var sortHow: TraktListSortHow

    var startDate: ZonedDateTime?

    var endDate: ZonedDateTime?

    var trendingUserCount: Int?

    var page: Int?

    var limit: Int?

    var isPrivateUser: Boolean?

    var xItemId: Int?

    var xItemType: String
}
