package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import java.time.Instant

interface TraktSyncHistoryPostMovie {
    var watchedAt: Instant?
    var title: String
    var year: Int?
    var ids: TraktMovieIdsImpl
}