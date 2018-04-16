package media.thehoard.thirdparty.api.trakt.exceptions

import java.net.HttpURLConnection

class TraktPreconditionFailedException(message: String = "Precondition Failed - use application/json content type") : TraktException(message) {
    init {
        this.statusCode = HttpURLConnection.HTTP_PRECON_FAILED
    }
}
