package com.atherapp.thirdparty.api.trakt.exceptions

import java.net.HttpURLConnection

class TraktConflictException(message: String = "Conflict - resource already created") : TraktException(message) {
    init {
        this.statusCode = HttpURLConnection.HTTP_CONFLICT
    }
}
