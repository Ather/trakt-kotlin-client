package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations.TraktSyncHistoryPostShowEpisodeImpl
import java.time.ZonedDateTime

interface TraktSyncHistoryPostShowSeason {
    var watchedAt: ZonedDateTime?
    var number: Int
    var episodes: MutableList<TraktSyncHistoryPostShowEpisodeImpl>
}