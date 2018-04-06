package media.thehoard.thirdparty.api.trakt.objects.get.watched

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedShowSeasonImpl
import java.time.ZonedDateTime

interface TraktWatchedShow {
    var plays: Int?

    var lastWatchedAt: ZonedDateTime?

    var show: TraktShowImpl

    var seasons: MutableList<TraktWatchedShowSeasonImpl>

}
