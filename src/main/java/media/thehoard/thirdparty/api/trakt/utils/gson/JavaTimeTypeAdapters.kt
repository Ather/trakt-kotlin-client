package media.thehoard.thirdparty.api.trakt.utils.gson

import com.github.salomonbrys.kotson.toJson
import com.google.gson.*
import media.thehoard.thirdparty.api.trakt.core.TraktConfiguration
import media.thehoard.thirdparty.api.trakt.extensions.fromTraktZone
import media.thehoard.thirdparty.api.trakt.extensions.lowerCase
import media.thehoard.thirdparty.api.trakt.extensions.toTraktTime
import media.thehoard.thirdparty.api.trakt.extensions.toTraktZone
import java.lang.reflect.Type
import java.time.*
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder

object DayOfWeekTypeAdapter : JsonDeserializer<DayOfWeek>, JsonSerializer<DayOfWeek> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): DayOfWeek? = if (json != null) DayOfWeek.valueOf(json.asString.toUpperCase()) else null

    override fun serialize(src: DayOfWeek?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? = src?.lowerCase()?.toJson()
}

object LocalTimeTypeAdapter : JsonDeserializer<LocalTime>, JsonSerializer<LocalTime> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): LocalTime? = if (json != null) LocalTime.parse(json.asString, DateTimeFormatter.ISO_LOCAL_TIME) else null

    override fun serialize(src: LocalTime?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? = src?.toTraktTime()?.toJson()
}

class ZonedDateTimeTypeAdapter(
        private val localTimezone: ZoneId = ZoneId.systemDefault()
) : JsonDeserializer<ZonedDateTime>, JsonSerializer<ZonedDateTime> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): ZonedDateTime? = if (json != null) Instant.parse(json.asString).atZone(TraktConfiguration.traktTimezone).fromTraktZone(localTimezone) else null

    override fun serialize(src: ZonedDateTime?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? = formatter.format(src?.toTraktZone()).toJson()

    companion object {
        internal val formatter: DateTimeFormatter = DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .optionalStart()
                .appendLiteral("T")
                .appendPattern("HH:mm:ss")
                .appendPattern(".SSS")
                .appendLiteral("Z")
                .optionalEnd()
                .toFormatter()
    }
}

object ZoneIdTypeAdapter : JsonDeserializer<ZoneId>, JsonSerializer<ZoneId> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): ZoneId? = if (json != null) ZoneId.of(json.asString) else null

    override fun serialize(src: ZoneId?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? = src?.toTraktZone()?.toJson()
}