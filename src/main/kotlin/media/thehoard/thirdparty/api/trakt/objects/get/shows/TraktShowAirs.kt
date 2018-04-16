package media.thehoard.thirdparty.api.trakt.objects.get.shows

import java.time.DayOfWeek
import java.time.LocalTime
import java.time.ZoneId

interface TraktShowAirs {
    var day: DayOfWeek?

    var time: LocalTime?

    var timezone: ZoneId?
}
