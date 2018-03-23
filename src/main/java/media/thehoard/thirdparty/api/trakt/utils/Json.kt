package media.thehoard.thirdparty.api.trakt.utils

import com.github.salomonbrys.kotson.registerTypeAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import media.thehoard.thirdparty.api.trakt.utils.gson.DateSerializer
import media.thehoard.thirdparty.api.trakt.utils.gson.InstantTypeAdapter
import java.time.Instant

import java.util.Date

object Json {
    private var gson: Gson? = null

    fun getGson(): Gson {
        if (gson == null)
            gson = GsonBuilder()
                    .registerTypeAdapter<Date>(typeAdapter = DateSerializer())
                    .registerTypeAdapter<Instant>(typeAdapter = InstantTypeAdapter)
                    .create()

        return this.gson!!
    }

    fun <T> serialize(obj: T): String {
        return getGson().toJson(obj)
    }

    fun <T> deserialize(json: String, outClass: Class<T>): T {
        return getGson().fromJson(json, outClass)
    }
}
