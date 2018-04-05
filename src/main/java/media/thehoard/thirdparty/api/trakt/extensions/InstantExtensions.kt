package media.thehoard.thirdparty.api.trakt.extensions

import media.thehoard.thirdparty.api.trakt.utils.gson.InstantTypeAdapter
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField

fun Instant.min(otherInstant: Instant?): Instant {
    if (otherInstant == null) return this
    return if (this < otherInstant) this
    else otherInstant
}

fun Instant.max(otherInstant: Instant?): Instant {
    if (otherInstant == null) return this
    return if (this > otherInstant) this
    else otherInstant
}

fun Instant.yearsBetween(otherInstant: Instant?): Int = this.get(ChronoField.YEAR) - otherInstant!!.get(ChronoField.YEAR)

fun Instant.toTraktDateString() = DateTimeFormatter.ISO_LOCAL_DATE.format(this.atZone(ZoneId.systemDefault()))

fun Instant.toTraktLongDateTimeString() = InstantTypeAdapter.formatter.format(this)
