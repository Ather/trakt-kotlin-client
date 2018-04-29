package com.atherapp.thirdparty.api.trakt.exceptions

open class TraktException : RuntimeException {

    var statusCode: Int = 0

    var requestUrl: String? = null

    var requestBody: String? = null

    var response: String? = null

    var serverReasonPhrase: String? = null

    constructor(message: String, innerException: Throwable) : super(message, innerException)

    constructor(message: String) : super(message)
}
