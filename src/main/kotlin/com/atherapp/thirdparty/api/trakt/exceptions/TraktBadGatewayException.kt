package com.atherapp.thirdparty.api.trakt.exceptions

import java.net.HttpURLConnection

class TraktBadGatewayException(message: String = "Bad Gateway") : TraktException(message) {
    init {
        this.statusCode = HttpURLConnection.HTTP_BAD_GATEWAY
    }
}
