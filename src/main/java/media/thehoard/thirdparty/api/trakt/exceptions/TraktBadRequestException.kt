package media.thehoard.thirdparty.api.trakt.exceptions

import com.google.api.client.http.HttpStatusCodes

class TraktBadRequestException @JvmOverloads constructor(message: String = "Bad Request - request couldn't be parsed") : TraktException(message) {
    init {
        this.statusCode = HttpStatusCodes.STATUS_CODE_BAD_REQUEST
    }
}
