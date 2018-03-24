package media.thehoard.thirdparty.api.trakt.exceptions

import com.google.api.client.http.HttpStatusCodes

class TraktServerException @JvmOverloads constructor(message: String = "Server Error") : TraktException(message) {
    init {
        this.statusCode = HttpStatusCodes.STATUS_CODE_SERVER_ERROR
    }
}
