package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations.TraktSyncRatingsPostShowSeasonImpl
import java.time.ZonedDateTime

interface TraktSyncRatingsPostShow {
    var title: String
    var year: Int?
    var ids: TraktShowIdsImpl
    var rating: Int?
    var ratedAt: ZonedDateTime?
    var seasons: MutableList<TraktSyncRatingsPostShowSeasonImpl>
}