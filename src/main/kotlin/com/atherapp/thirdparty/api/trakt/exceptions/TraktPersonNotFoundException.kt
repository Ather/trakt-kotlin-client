package com.atherapp.thirdparty.api.trakt.exceptions

class TraktPersonNotFoundException(message: String, personId: String) : TraktObjectNotFoundException(message, personId) {

    constructor(personId: String) : this("Person Not Found - method exists, but no record found", personId)
}
