package media.thehoard.thirdparty.api.trakt.exceptions

import com.google.api.client.http.HttpStatusCodes

class TraktMethodNotFoundException @JvmOverloads constructor(message: String = "Method Not Found - method doesn't exists") : TraktException(message) {
    init {
        this.statusCode = HttpStatusCodes.STATUS_CODE_METHOD_NOT_ALLOWED
    }
}
