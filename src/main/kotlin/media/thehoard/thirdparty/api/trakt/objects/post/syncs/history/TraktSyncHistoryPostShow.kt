package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowIds
import java.time.ZonedDateTime

interface TraktSyncHistoryPostShow {
    var watchedAt: ZonedDateTime?
    var title: String
    var year: Int?
    var ids: TraktShowIds
    var seasons: MutableList<TraktSyncHistoryPostShowSeason>
}