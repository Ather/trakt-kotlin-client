package media.thehoard.thirdparty.api.trakt.utils.gson;

import com.google.gson.*;
import media.thehoard.thirdparty.api.trakt.utils.Json;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Gson Date serializer to automatically convert to and from GMT times for Trakt.tv
 */
public class DateSerializer implements JsonDeserializer<Date>, JsonSerializer<Date> {
	/**
	 * This must <i>always</i> contain at least one element,
	 * @see Json#getGson()
	 */
	public static final String[] DATE_FORMATS = {"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd"};

	private static final DateFormat[] DATE_FORMATTERS = Arrays.stream(DATE_FORMATS).map(DateSerializer::initializeAdapter).toArray(DateFormat[]::new);

	private static DateFormat initializeAdapter(String df) {
		SimpleDateFormat sdf = new SimpleDateFormat(df, Locale.US);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf;
	}

	@Override
	public synchronized Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
			JsonParseException {
		for (DateFormat currentFormatter : DATE_FORMATTERS) {
			try {
				return currentFormatter.parse(json.getAsString());
			} catch (ParseException e) {
			}
		}
		throw new JsonParseException("Invalid/unparseable date provided: " + json.getAsString());
	}

	@Override
	public synchronized JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(DATE_FORMATTERS[0].format(src));
	}
}
