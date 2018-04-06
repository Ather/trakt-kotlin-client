package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations.TraktSyncHistoryPostShowSeasonImpl
import java.time.ZonedDateTime

interface TraktSyncHistoryPostShow {
    var watchedAt: ZonedDateTime?
    var title: String
    var year: Int?
    var ids: TraktShowIdsImpl
    var seasons: MutableList<TraktSyncHistoryPostShowSeasonImpl>
}