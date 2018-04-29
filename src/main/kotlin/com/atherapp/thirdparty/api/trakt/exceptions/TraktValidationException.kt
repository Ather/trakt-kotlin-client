package com.atherapp.thirdparty.api.trakt.exceptions

class TraktValidationException(message: String = "Unprocessable Entity - validation errors") : TraktException(message)
