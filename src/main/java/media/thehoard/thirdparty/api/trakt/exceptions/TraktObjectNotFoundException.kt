package media.thehoard.thirdparty.api.trakt.exceptions

import com.google.api.client.http.HttpStatusCodes

open class TraktObjectNotFoundException(message: String, var objectId: String) : TraktException(message) {

    init {
        this.statusCode = HttpStatusCodes.STATUS_CODE_NOT_FOUND
    }

    constructor(objectId: String) : this("Object Not Found - method exists, but no record found", objectId) {}
}
