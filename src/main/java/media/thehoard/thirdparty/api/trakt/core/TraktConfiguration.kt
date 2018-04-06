package media.thehoard.thirdparty.api.trakt.core

import org.asynchttpclient.AsyncHttpClient
import java.time.ZoneId

class TraktConfiguration {

    var localTimezone: ZoneId = ZoneId.systemDefault()

    var apiVersion = 2

    var useSandboxEnvironment: Boolean = false

    val baseUrl: String
        get() = if (useSandboxEnvironment) Constants.API_STAGING_URL else Constants.API_URL

    var forceAuthorization: Boolean = false

    var throwResponseExceptions = true

    companion object {
        val traktTimezone: ZoneId = ZoneId.of("GMT")

        internal var httpClient: AsyncHttpClient? = null
    }
}
