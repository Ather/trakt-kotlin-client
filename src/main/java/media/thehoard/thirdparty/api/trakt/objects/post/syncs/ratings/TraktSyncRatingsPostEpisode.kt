package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import java.time.Instant

interface TraktSyncRatingsPostEpisode {
    var ids: TraktEpisodeIdsImpl
    var rating: Int?
    var ratedAt: Instant?
}