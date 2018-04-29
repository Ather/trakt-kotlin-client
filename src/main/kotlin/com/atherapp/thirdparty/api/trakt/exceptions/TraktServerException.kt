package com.atherapp.thirdparty.api.trakt.exceptions

import java.net.HttpURLConnection

class TraktServerException(message: String = "Server Error") : TraktException(message) {
    init {
        this.statusCode = HttpURLConnection.HTTP_INTERNAL_ERROR
    }
}
