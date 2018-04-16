package media.thehoard.thirdparty.api.trakt.exceptions

import java.net.HttpURLConnection

class TraktServerUnavailableException(message: String = "Server Unavailable - server overloaded (try again in 30s)") : TraktException(message) {
    init {
        this.statusCode = HttpURLConnection.HTTP_UNAVAILABLE
    }
}
