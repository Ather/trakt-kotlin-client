package media.thehoard.thirdparty.api.trakt.utils.gson

import com.github.salomonbrys.kotson.toJson
import com.google.gson.*
import media.thehoard.thirdparty.api.trakt.core.TraktConfiguration
import media.thehoard.thirdparty.api.trakt.extensions.fromTraktZone
import media.thehoard.thirdparty.api.trakt.extensions.toTraktZone
import java.lang.reflect.Type
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder

class ZonedDateTimeTypeAdapter(
        private val localTimezone: ZoneId = ZoneId.systemDefault()
) : JsonDeserializer<ZonedDateTime>, JsonSerializer<ZonedDateTime> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): ZonedDateTime = Instant.parse(json?.asString).atZone(TraktConfiguration.traktTimezone).fromTraktZone(localTimezone)

    override fun serialize(src: ZonedDateTime?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement = formatter.format(src?.toTraktZone()).toJson()

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