package media.thehoard.thirdparty.api.trakt.exceptions

import com.google.api.client.http.HttpStatusCodes

class TraktBadGatewayException @JvmOverloads constructor(message: String = "Bad Gateway") : TraktException(message) {
    init {
        this.statusCode = HttpStatusCodes.STATUS_CODE_BAD_GATEWAY
    }
}
