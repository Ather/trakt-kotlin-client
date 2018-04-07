package media.thehoard.thirdparty.api.trakt.utils

import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import media.thehoard.thirdparty.api.trakt.utils.gson.DayOfWeekTypeAdapter
import media.thehoard.thirdparty.api.trakt.utils.gson.LocalTimeTypeAdapter
import media.thehoard.thirdparty.api.trakt.utils.gson.ZoneIdTypeAdapter
import media.thehoard.thirdparty.api.trakt.utils.gson.ZonedDateTimeTypeAdapter
import java.lang.reflect.Type
import java.time.DayOfWeek
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime

object Json {
    private val STANDARD_ADAPTERS = arrayOf(
            DayOfWeek::class to DayOfWeekTypeAdapter,
            LocalTime::class to LocalTimeTypeAdapter,
            ZonedDateTime::class to ZonedDateTimeTypeAdapter(),
            ZoneId::class to ZoneIdTypeAdapter
    )

    /**
     * Array of currently-in-use type adapters stored as ( Type, IsCustom )
     */
    private var currentAdapters = arrayOf<Pair<Type, Boolean>>()

    var gson: Gson = newGson()
        internal set

    fun serialize(src: Any): String = gson.toJson(src)

    fun <T> deserialize(json: String, typeOfT: Type): T = gson.fromJson(json, typeOfT)

    fun <T> deserialize(json: JsonElement, typeOfT: Type): T = gson.fromJson(json, typeOfT)

    inline fun <reified T : Any> deserialize(json: String): T = gson.fromJson(json)

    @Synchronized
    internal fun newGson(vararg typeAdapters: Pair<Type, Any>, retainAdapters: Boolean = true): Gson {
        val builder = GsonBuilder()

        // List of adapters being registered to Gson
        val usedAdapters = mutableListOf<Pair<Type, Boolean>>()

        // Register the new adapters
        for ((type, adapter) in typeAdapters) {
            builder.registerTypeAdapter(type, adapter)
            usedAdapters.add(type to true)
        }

        // Register any old adapters not already replaced if we want to retain the old adapters
        if (retainAdapters) {
            for ((type, adapter) in currentAdapters) {
                if (type to true !in usedAdapters) {
                    builder.registerTypeAdapter(type, adapter)
                    usedAdapters.add(type to true)
                }
            }
        }

        // Register old and standard adapters
        for ((TYPE, ADAPTER) in STANDARD_ADAPTERS) {
            // Verify that a custom adapter wasn't already registered
            if ((TYPE.javaObjectType to true) !in usedAdapters) {
                builder.registerTypeAdapter(TYPE.javaObjectType, ADAPTER)
                usedAdapters.add(TYPE.javaObjectType to false)
            }
        }

        currentAdapters = usedAdapters.toTypedArray()

        return builder.create()
    }
}
