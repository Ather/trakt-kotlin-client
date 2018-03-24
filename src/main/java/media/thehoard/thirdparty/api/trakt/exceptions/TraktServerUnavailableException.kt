package media.thehoard.thirdparty.api.trakt.exceptions

import com.google.api.client.http.HttpStatusCodes

class TraktServerUnavailableException @JvmOverloads constructor(message: String = "Server Unavailable - server overloaded (try again in 30s)") : TraktException(message) {
    init {
        this.statusCode = HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE
    }
}
