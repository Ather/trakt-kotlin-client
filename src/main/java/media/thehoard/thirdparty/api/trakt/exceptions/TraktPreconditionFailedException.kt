package media.thehoard.thirdparty.api.trakt.exceptions

import com.google.api.client.http.HttpStatusCodes

class TraktPreconditionFailedException @JvmOverloads constructor(message: String = "Precondition Failed - use application/json content type") : TraktException(message) {
    init {
        this.statusCode = HttpStatusCodes.STATUS_CODE_PRECONDITION_FAILED
    }
}
