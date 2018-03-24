package media.thehoard.thirdparty.api.trakt.objects.get.collections

import java.time.Instant

interface TraktCollectionShowEpisode {
    var number: Int?

    var collectedAt: Instant?
}
