package com.atherapp.thirdparty.api.trakt.exceptions

import java.net.HttpURLConnection

class TraktMethodNotFoundException(message: String = "Method Not Found - method doesn't exists") : TraktException(message) {
    init {
        this.statusCode = HttpURLConnection.HTTP_NOT_FOUND
    }
}
