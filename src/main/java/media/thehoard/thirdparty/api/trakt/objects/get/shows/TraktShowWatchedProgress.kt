package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonWatchedProgressImpl
import java.time.ZonedDateTime

interface TraktShowWatchedProgress : TraktShowProgress {
    var lastWatchedAt: ZonedDateTime?

    var seasons: MutableList<TraktSeasonWatchedProgressImpl>
}
