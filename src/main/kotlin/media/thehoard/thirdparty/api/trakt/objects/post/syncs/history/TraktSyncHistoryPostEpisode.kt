package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds
import java.time.ZonedDateTime

interface TraktSyncHistoryPostEpisode {
    var watchedAt: ZonedDateTime?
    var ids: TraktEpisodeIds
}