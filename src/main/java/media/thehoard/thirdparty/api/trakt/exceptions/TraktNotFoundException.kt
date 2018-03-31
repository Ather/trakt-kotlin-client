package media.thehoard.thirdparty.api.trakt.exceptions

import java.net.HttpURLConnection

class TraktNotFoundException(message: String) : TraktException(message) {
    init {
        this.statusCode = HttpURLConnection.HTTP_NOT_FOUND
    }
}
