package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import java.time.Instant

interface TraktSyncHistoryPostEpisode {
    var watchedAt: Instant?
    var ids: TraktEpisodeIdsImpl
}