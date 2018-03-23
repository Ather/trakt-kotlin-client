package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonWatchedProgressImpl

import java.time.Instant

interface TraktShowWatchedProgress : TraktShowProgress {
    var lastWatchedAt: Instant?

    var seasons: List<TraktSeasonWatchedProgressImpl>
}
