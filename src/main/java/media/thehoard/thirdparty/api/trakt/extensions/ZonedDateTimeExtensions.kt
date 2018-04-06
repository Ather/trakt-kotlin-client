package media.thehoard.thirdparty.api.trakt.extensions

import media.thehoard.thirdparty.api.trakt.core.TraktConfiguration
import media.thehoard.thirdparty.api.trakt.utils.gson.ZonedDateTimeTypeAdapter
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun ZonedDateTime.min(otherInstant: ZonedDateTime?): ZonedDateTime {
    if (otherInstant == null) return this
    return if (this < otherInstant) this
    else otherInstant
}

fun ZonedDateTime.max(otherInstant: ZonedDateTime?): ZonedDateTime {
    if (otherInstant == null) return this
    return if (this > otherInstant) this
    else otherInstant
}

fun ZonedDateTime.yearsBetween(otherInstant: ZonedDateTime?): Int = this.year - (otherInstant?.year?:0)

fun ZonedDateTime.toTraktDateString() = DateTimeFormatter.ISO_LOCAL_DATE.format(this)

fun ZonedDateTime.toTraktLongDateTimeString() = ZonedDateTimeTypeAdapter.formatter.format(this)

fun ZonedDateTime.fromTraktZone(toZone: ZoneId = ZoneId.systemDefault()) = this.withZoneSameInstant(toZone)

fun ZonedDateTime.toTraktZone() = this.withZoneSameInstant(TraktConfiguration.traktTimezone)