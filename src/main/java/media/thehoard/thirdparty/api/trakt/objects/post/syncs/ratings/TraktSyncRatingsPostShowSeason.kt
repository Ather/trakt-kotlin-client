package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations.TraktSyncRatingsPostShowEpisodeImpl
import java.time.Instant

interface TraktSyncRatingsPostShowSeason {
    var number: Int
    var rating: Int?
    var ratedAt: Instant?
    var episodes: MutableList<TraktSyncRatingsPostShowEpisodeImpl>
}