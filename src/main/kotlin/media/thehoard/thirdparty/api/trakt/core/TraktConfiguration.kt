package media.thehoard.thirdparty.api.trakt.core

import media.thehoard.thirdparty.api.trakt.utils.Json
import media.thehoard.thirdparty.api.trakt.utils.gson.ZonedDateTimeTypeAdapter
import org.asynchttpclient.AsyncHttpClient
import java.time.ZoneId
import java.time.ZonedDateTime
import kotlin.properties.Delegates

class TraktConfiguration {
    var apiVersion = 2

    var useSandboxEnvironment: Boolean = false

    val baseUrl: String
        get() = if (useSandboxEnvironment) Constants.API_STAGING_URL else Constants.API_URL

    var forceAuthorization: Boolean = false

    var throwResponseExceptions = true

    companion object {
        var localTimezone: ZoneId by Delegates.observable(ZoneId.systemDefault()) { _, _, newZoneId ->
            Json.newGson(ZonedDateTime::class.java to ZonedDateTimeTypeAdapter(newZoneId))
        }

        val traktTimezone: ZoneId = ZoneId.of("GMT")

        internal var httpClient: AsyncHttpClient? = null
    }
}
