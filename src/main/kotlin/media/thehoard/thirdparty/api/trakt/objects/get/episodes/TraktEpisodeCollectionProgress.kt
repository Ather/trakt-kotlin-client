package media.thehoard.thirdparty.api.trakt.objects.get.episodes

import java.time.ZonedDateTime

interface TraktEpisodeCollectionProgress : TraktEpisodeProgress {
    var collectedAt: ZonedDateTime?

}
