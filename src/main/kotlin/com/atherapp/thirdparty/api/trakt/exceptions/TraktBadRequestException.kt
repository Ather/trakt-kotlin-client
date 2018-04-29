package com.atherapp.thirdparty.api.trakt.exceptions

import java.net.HttpURLConnection

class TraktBadRequestException(message: String = "Bad Request - request couldn't be parsed") : TraktException(message) {
    init {
        this.statusCode = HttpURLConnection.HTTP_BAD_REQUEST
    }
}
