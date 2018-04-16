package media.thehoard.thirdparty.api.trakt.objects.get.calendars

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktCalendarShow : TraktShow, TraktCalendarEpisode {
    var firstAiredInCalendar: ZonedDateTime?

    var episode: TraktEpisode

    var show: TraktShow

}
