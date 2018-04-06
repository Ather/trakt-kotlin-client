package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import java.time.ZonedDateTime

interface TraktSyncCollectionPostEpisode {
    var collectedAt: ZonedDateTime?

    var ids: TraktEpisodeIdsImpl

    var metadata: TraktMetadataImpl?
}