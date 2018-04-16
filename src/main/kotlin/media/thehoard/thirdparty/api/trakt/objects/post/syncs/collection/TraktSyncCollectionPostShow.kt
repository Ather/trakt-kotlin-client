package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktMetadata
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowIds
import java.time.ZonedDateTime

interface TraktSyncCollectionPostShow {
    var collectedAt: ZonedDateTime?

    var title: String

    var year: Int?

    var ids: TraktShowIds

    var metadata: TraktMetadata?

    var seasons: MutableList<TraktSyncCollectionPostShowSeason>
}