package media.thehoard.thirdparty.api.trakt.responses.interfaces

import java.time.ZonedDateTime

interface ITraktResponseHeaders {
    var sortBy: String

    var sortHow: String

    var startDate: ZonedDateTime?

    var endDate: ZonedDateTime?

    var trendingUserCount: Int?

    var page: Int?

    var limit: Int?

    var isPrivateUser: Boolean?

    var xItemId: Int?

    var xItemType: String
}
