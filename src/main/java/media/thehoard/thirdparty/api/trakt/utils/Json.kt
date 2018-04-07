package media.thehoard.thirdparty.api.trakt.utils

import com.github.salomonbrys.kotson.fromJson
import com.github.salomonbrys.kotson.registerTypeAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import media.thehoard.thirdparty.api.trakt.utils.gson.DateSerializer
import media.thehoard.thirdparty.api.trakt.utils.gson.ZonedDateTimeTypeAdapter
import java.lang.reflect.Type
import java.time.ZonedDateTime
import java.util.*

object Json {
    val gson: Gson = GsonBuilder()
            .registerTypeAdapter<Date>(typeAdapter = DateSerializer)
            .registerTypeAdapter<ZonedDateTime>(typeAdapter = ZonedDateTimeTypeAdapter())
            .create()

    fun serialize(src: Any): String = gson.toJson(src)

    fun <T> deserialize(json: String, typeOfT: Type): T = gson.fromJson(json, typeOfT)

    fun <T> deserialize(json: JsonElement, typeOfT: Type): T = gson.fromJson(json, typeOfT)

    inline fun <reified T : Any> deserialize(json:String): T = gson.fromJson(json)
}
