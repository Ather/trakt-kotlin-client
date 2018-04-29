package com.atherapp.thirdparty.api.trakt.objects.get.calendars

import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktCalendarShow : TraktShow, TraktCalendarEpisode {
    var firstAiredInCalendar: ZonedDateTime?

    var episode: TraktEpisode

    var show: TraktShow

}
