package media.thehoard.thirdparty.api.trakt.utils.gson

import com.github.salomonbrys.kotson.toJson
import com.google.gson.*
import java.lang.reflect.Type
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder

object InstantTypeAdapter : JsonDeserializer<Instant>, JsonSerializer<Instant> {
    val formatter: DateTimeFormatter = DateTimeFormatterBuilder()
            .append(DateTimeFormatter.ISO_LOCAL_DATE)
            .optionalStart()
            .appendLiteral("T")
            .appendPattern("HH:mm:ss")
            .appendPattern(".SSS")
            .appendLiteral("Z")
            .optionalEnd()
            .toFormatter()

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Instant = formatter.parse(json!!.asString, Instant::from)

    override fun serialize(src: Instant?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement = formatter.format(src).toJson()
}