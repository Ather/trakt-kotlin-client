package media.thehoard.thirdparty.api.trakt.exceptions

import com.google.api.client.http.HttpStatusCodes

class TraktNotFoundException(message: String) : TraktException(message) {
    init {
        this.statusCode = HttpStatusCodes.STATUS_CODE_NOT_FOUND
    }
}
