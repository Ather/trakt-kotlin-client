package com.atherapp.thirdparty.api.trakt.exceptions

class TraktRateLimitException(message: String = "Slow Down - your app is polling too quickly") : TraktException(message)
