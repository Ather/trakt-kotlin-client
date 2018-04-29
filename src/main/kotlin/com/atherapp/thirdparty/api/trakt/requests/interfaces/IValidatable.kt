package com.atherapp.thirdparty.api.trakt.requests.interfaces

interface IValidatable {
    fun validate(variableName: String = "input")
}
