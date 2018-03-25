package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations.TraktSyncHistoryPostShowEpisodeImpl
import java.time.Instant

interface TraktSyncHistoryPostShowSeason {
    var watchedAt: Instant?
    var number: Int
    var episodes: MutableList<TraktSyncHistoryPostShowEpisodeImpl>
}