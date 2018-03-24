package media.thehoard.thirdparty.api.trakt.exceptions

import com.google.api.client.http.HttpStatusCodes

class TraktConflictException @JvmOverloads constructor(message: String = "Conflict - resource already created") : TraktException(message) {
    init {
        this.statusCode = HttpStatusCodes.STATUS_CODE_CONFLICT
    }
}
