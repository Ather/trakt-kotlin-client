package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations.TraktSyncRatingsPostShowSeasonImpl
import java.time.Instant

interface TraktSyncRatingsPostShow {
    var title: String
    var year: Int?
    var ids: TraktShowIdsImpl
    var rating: Int?
    var ratedAt: Instant?
    var seasons: MutableList<TraktSyncRatingsPostShowSeasonImpl>
}