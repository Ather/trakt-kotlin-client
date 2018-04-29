package com.atherapp.thirdparty.api.trakt.exceptions

import java.net.HttpURLConnection

open class TraktObjectNotFoundException(message: String, var objectId: String) : TraktException(message) {

    init {
        this.statusCode = HttpURLConnection.HTTP_NOT_FOUND
    }

    constructor(objectId: String) : this("Object Not Found - method exists, but no record found", objectId)
}
