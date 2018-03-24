package media.thehoard.thirdparty.api.trakt.objects.get.episodes

import java.time.Instant
import java.util.Date

interface TraktEpisodeCollectionProgress : TraktEpisodeProgress {
    var collectedAt: Instant?

}
