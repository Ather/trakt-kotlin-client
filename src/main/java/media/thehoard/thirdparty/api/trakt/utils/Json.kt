package media.thehoard.thirdparty.api.trakt.utils

import com.github.salomonbrys.kotson.registerTypeAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import media.thehoard.thirdparty.api.trakt.utils.gson.DateSerializer
import media.thehoard.thirdparty.api.trakt.utils.gson.InstantTypeAdapter
import java.time.Instant
import java.util.*

object Json {
    val gson: Gson = GsonBuilder()
            .registerTypeAdapter<Date>(typeAdapter = DateSerializer)
            .registerTypeAdapter<Instant>(typeAdapter = InstantTypeAdapter)
            .create()
}
