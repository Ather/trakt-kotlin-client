package media.thehoard.thirdparty.api.trakt.objects.get.watched

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedShowSeasonImpl

import java.time.Instant

interface TraktWatchedShow {
    var plays: Int?

    var lastWatchedAt: Instant?

    var show: TraktShowImpl

    var seasons: MutableList<TraktWatchedShowSeasonImpl>

}
