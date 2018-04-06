package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import java.time.ZonedDateTime

interface TraktSyncHistoryPostMovie {
    var watchedAt: ZonedDateTime?
    var title: String
    var year: Int?
    var ids: TraktMovieIdsImpl
}