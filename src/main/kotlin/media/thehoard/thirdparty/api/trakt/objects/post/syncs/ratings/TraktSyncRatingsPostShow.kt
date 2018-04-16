package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowIds
import java.time.ZonedDateTime

interface TraktSyncRatingsPostShow {
    var title: String
    var year: Int?
    var ids: TraktShowIds
    var rating: Int?
    var ratedAt: ZonedDateTime?
    var seasons: MutableList<TraktSyncRatingsPostShowSeason>
}