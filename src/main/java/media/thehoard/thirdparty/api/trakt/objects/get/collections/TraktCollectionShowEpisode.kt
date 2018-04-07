package media.thehoard.thirdparty.api.trakt.objects.get.collections

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl
import java.time.ZonedDateTime

interface TraktCollectionShowEpisode {
    var number: Int?

    var collectedAt: ZonedDateTime?

    var metadata: TraktMetadataImpl?
}
