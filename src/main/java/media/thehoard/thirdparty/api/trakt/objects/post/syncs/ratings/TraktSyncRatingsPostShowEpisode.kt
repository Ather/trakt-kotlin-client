package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings

import java.time.Instant

interface TraktSyncRatingsPostShowEpisode {
    var number: Int
    var rating: Int?
    var ratedAt: Instant?
}