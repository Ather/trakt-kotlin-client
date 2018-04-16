package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktMetadata
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds
import java.time.ZonedDateTime

interface TraktSyncCollectionPostEpisode {
    var collectedAt: ZonedDateTime?

    var ids: TraktEpisodeIds

    var metadata: TraktMetadata?
}