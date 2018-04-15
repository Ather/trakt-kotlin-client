package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonWatchedProgress
import java.time.ZonedDateTime

interface TraktShowWatchedProgress : TraktShowProgress {
    var lastWatchedAt: ZonedDateTime?

    var seasons: MutableList<TraktSeasonWatchedProgress>
}
