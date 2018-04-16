package media.thehoard.thirdparty.api.trakt.extensions

import media.thehoard.thirdparty.api.trakt.core.TraktConfiguration
import java.time.DayOfWeek
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

fun DayOfWeek.lowerCase(): String = this.getDisplayName(TextStyle.FULL, Locale.US)

fun LocalTime.toTraktTime() = "${this.hour}:${this.minute}"

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

fun ZonedDateTime.yearsBetween(otherInstant: ZonedDateTime?): Int = this.year - (otherInstant?.year ?: 0)

fun ZonedDateTime.toTraktDateString(): String = DateTimeFormatter.ISO_LOCAL_DATE.format(this)

fun ZonedDateTime.toTraktLongDateTimeString(): String = DateTimeFormatter.ISO_INSTANT.format(this)

fun ZonedDateTime.fromTraktZone(toZone: ZoneId = ZoneId.systemDefault()): ZonedDateTime = this.withZoneSameInstant(toZone)

fun ZonedDateTime.toTraktZone(): ZonedDateTime = this.withZoneSameInstant(TraktConfiguration.traktTimezone)

fun ZoneId.toTraktZone(): String = this.id