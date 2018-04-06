package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonCollectionProgressImpl
import java.time.ZonedDateTime

interface TraktShowCollectionProgress : TraktShowProgress {
    var lastCollectedAt: ZonedDateTime?

    var seasons: MutableList<TraktSeasonCollectionProgressImpl>
}