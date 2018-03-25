package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history

import java.time.Instant

interface TraktSyncHistoryPostShowEpisode {
    var watchedAt: Instant?
    var number: Int
}