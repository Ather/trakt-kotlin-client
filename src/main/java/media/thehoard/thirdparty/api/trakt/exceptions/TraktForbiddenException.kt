package media.thehoard.thirdparty.api.trakt.exceptions

import com.google.api.client.http.HttpStatusCodes

class TraktForbiddenException @JvmOverloads constructor(message: String = "Forbidden - invalid API key or unapproved app") : TraktException(message) {
    init {
        this.statusCode = HttpStatusCodes.STATUS_CODE_FORBIDDEN
    }
}
