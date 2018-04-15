package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonCollectionProgress
import java.time.ZonedDateTime

interface TraktShowCollectionProgress : TraktShowProgress {
    var lastCollectedAt: ZonedDateTime?

    var seasons: MutableList<TraktSeasonCollectionProgress>
}