package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

interface TraktRecentlyUpdatedShow : TraktShow {
    override var updatedAt: ZonedDateTime?

    var show: TraktShowImpl
}
