package media.thehoard.thirdparty.api.trakt.objects.get.movies

import java.time.ZonedDateTime

interface TraktRecentlyUpdatedMovie : TraktMovie {
    var recentlyUpdatedAt: ZonedDateTime?

    var movie: TraktMovie

}
