package media.thehoard.thirdparty.api.trakt.exceptions

import java.time.Instant

class TraktCheckinException(message: String) : TraktException(message) {
    var expiresAt: Instant? = null
}
