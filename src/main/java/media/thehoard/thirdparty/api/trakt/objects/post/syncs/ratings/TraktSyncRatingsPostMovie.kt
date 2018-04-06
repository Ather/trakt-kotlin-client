package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import java.time.ZonedDateTime

interface TraktSyncRatingsPostMovie {
    var title: String
    var year: Int?
    var ids: TraktMovieIdsImpl
    var rating: Int?
    var ratedAt: ZonedDateTime?
}