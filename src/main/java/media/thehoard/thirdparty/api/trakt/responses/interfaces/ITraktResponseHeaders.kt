package media.thehoard.thirdparty.api.trakt.responses.interfaces

import java.time.Instant

interface ITraktResponseHeaders {
    var sortBy: String

    var sortHow: String

    var startDate: Instant?

    var endDate: Instant?

    var trendingUserCount: Int?

    var page: Int?

    var limit: Int?

    var isPrivateUser: Boolean?

    var xItemId: Int?

    var xItemType: String
}
