package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations.TraktSyncCollectionPostShowSeasonImpl
import java.time.ZonedDateTime

interface TraktSyncCollectionPostShow {
    var collectedAt: ZonedDateTime?

    var title: String

    var year: Int?

    var ids: TraktShowIdsImpl

    var metadata: TraktMetadataImpl?

    var seasons: MutableList<TraktSyncCollectionPostShowSeasonImpl>
}