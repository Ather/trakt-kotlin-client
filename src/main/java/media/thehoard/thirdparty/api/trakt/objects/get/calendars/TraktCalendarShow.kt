package media.thehoard.thirdparty.api.trakt.objects.get.calendars

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

import java.time.Instant

interface TraktCalendarShow : TraktShow, TraktCalendarEpisode {
    override var firstAired: Instant?

    var episode: TraktEpisodeImpl

    var show: TraktShowImpl

}
