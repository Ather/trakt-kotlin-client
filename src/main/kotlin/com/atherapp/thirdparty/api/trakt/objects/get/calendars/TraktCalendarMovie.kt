package com.atherapp.thirdparty.api.trakt.objects.get.calendars

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import java.time.LocalDate

interface TraktCalendarMovie : TraktMovie {
    var calendarRelease: LocalDate?

    var movie: TraktMovie

}
