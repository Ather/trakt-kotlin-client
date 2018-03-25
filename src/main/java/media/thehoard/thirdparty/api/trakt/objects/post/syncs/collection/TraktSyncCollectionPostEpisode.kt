package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import java.time.Instant

interface TraktSyncCollectionPostEpisode {
    var collectedAt: Instant?

    var ids: TraktEpisodeIdsImpl

    var metadata: TraktMetadataImpl?
}