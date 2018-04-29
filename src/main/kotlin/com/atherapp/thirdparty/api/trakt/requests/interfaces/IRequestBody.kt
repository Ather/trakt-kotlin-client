package com.atherapp.thirdparty.api.trakt.requests.interfaces

import com.atherapp.thirdparty.api.trakt.utils.Json

interface IRequestBody : IValidatable {
    fun toJson(): String = Json.serialize(this)
}