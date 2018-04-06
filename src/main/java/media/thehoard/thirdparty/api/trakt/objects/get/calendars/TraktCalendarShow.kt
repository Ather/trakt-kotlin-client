package media.thehoard.thirdparty.api.trakt.objects.get.calendars

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

interface TraktCalendarShow : TraktShow, TraktCalendarEpisode {
    override var firstAired: ZonedDateTime?

    var episode: TraktEpisodeImpl

    var show: TraktShowImpl

}
