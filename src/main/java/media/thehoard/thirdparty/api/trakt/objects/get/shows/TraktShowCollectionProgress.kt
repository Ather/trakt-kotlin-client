package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonCollectionProgressImpl
import java.time.Instant

interface TraktShowCollectionProgress : TraktShowProgress {
    var lastCollectedAt: Instant?

    var seasons: List<TraktSeasonCollectionProgressImpl>
}