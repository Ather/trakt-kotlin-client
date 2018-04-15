package media.thehoard.thirdparty.api.trakt.objects.get.watched

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktWatchedShow {
    var plays: Int?

    var lastWatchedAt: ZonedDateTime?

    var show: TraktShow

    var seasons: MutableList<TraktWatchedShowSeason>

}
