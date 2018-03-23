package media.thehoard.thirdparty.api.trakt.utils.gson

import com.google.gson.*
import media.thehoard.thirdparty.api.trakt.utils.Json
import java.lang.reflect.Type
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Gson Date serializer to automatically convert to and from GMT times for Trakt.tv
 */
object DateSerializer : JsonDeserializer<Date>, JsonSerializer<Date> {

    @Synchronized
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Date {
        for (currentFormatter in DATE_FORMATTERS) {
            try {
                return currentFormatter.parse(json.asString)
            } catch (e: ParseException) {
            }
        }
        throw JsonParseException("Invalid/unparseable date provided: " + json.asString)
    }

    @Synchronized
    override fun serialize(src: Date, typeOfSrc: Type, context: JsonSerializationContext): JsonElement = JsonPrimitive(DATE_FORMATTERS[0].format(src))

    /**
     * This must *always* contain at least one element,
     * @see Json.getGson
     */
    val DATE_FORMATS = arrayOf("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd")

    private val DATE_FORMATTERS = DATE_FORMATS.map { initializeAdapter(it) }.toTypedArray()

    private fun initializeAdapter(df: String): DateFormat = SimpleDateFormat(df, Locale.US).apply { timeZone = TimeZone.getTimeZone("GMT") }
}
