package media.thehoard.thirdparty.api.trakt.objects.get.collections

import java.time.ZonedDateTime

interface TraktCollectionShowEpisode {
    var number: Int?

    var collectedAt: ZonedDateTime?
}
