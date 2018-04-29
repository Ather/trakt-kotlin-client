package com.atherapp.thirdparty.api.trakt.exceptions

import java.net.HttpURLConnection

class TraktAuthorizationException(message: String = "Unauthorized - OAuth must be provided") : TraktException(message) {
    init {
        statusCode = HttpURLConnection.HTTP_UNAUTHORIZED
    }
}
