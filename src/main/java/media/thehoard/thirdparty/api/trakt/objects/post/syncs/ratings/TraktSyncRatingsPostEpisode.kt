package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds
import java.time.ZonedDateTime

interface TraktSyncRatingsPostEpisode {
    var ids: TraktEpisodeIds
    var rating: Int?
    var ratedAt: ZonedDateTime?
}