package media.thehoard.thirdparty.api.trakt.exceptions

import java.time.ZonedDateTime

class TraktCheckinException(message: String) : TraktException(message) {
    var expiresAt: ZonedDateTime? = null
}
