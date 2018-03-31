package media.thehoard.thirdparty.api.trakt.exceptions

import java.net.HttpURLConnection

class TraktForbiddenException(message: String = "Forbidden - invalid API key or unapproved app") : TraktException(message) {
    init {
        this.statusCode = HttpURLConnection.HTTP_FORBIDDEN
    }
}
