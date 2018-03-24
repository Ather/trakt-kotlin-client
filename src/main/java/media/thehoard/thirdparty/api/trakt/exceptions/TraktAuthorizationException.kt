package media.thehoard.thirdparty.api.trakt.exceptions

import com.google.api.client.http.HttpStatusCodes

class TraktAuthorizationException @JvmOverloads constructor(message: String = "Unauthorized - OAuth must be provided") : TraktException(message) {
    init {
        statusCode = HttpStatusCodes.STATUS_CODE_UNAUTHORIZED
    }
}
