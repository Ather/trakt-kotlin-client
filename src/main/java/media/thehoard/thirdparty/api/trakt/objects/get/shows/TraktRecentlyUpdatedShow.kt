package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

interface TraktRecentlyUpdatedShow : TraktShow {
    var recentlyUpdatedAt: ZonedDateTime?

    var show: TraktShowImpl
}
