package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings

import java.time.ZonedDateTime

interface TraktSyncRatingsPostShowSeason {
    var number: Int
    var rating: Int?
    var ratedAt: ZonedDateTime?
    var episodes: MutableList<TraktSyncRatingsPostShowEpisode>
}