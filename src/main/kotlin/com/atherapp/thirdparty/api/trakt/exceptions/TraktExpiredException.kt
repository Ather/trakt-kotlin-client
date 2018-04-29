package com.atherapp.thirdparty.api.trakt.exceptions

class TraktExpiredException(message: String = "Expired - the tokens have expired, restart the process") : TraktException(message)
