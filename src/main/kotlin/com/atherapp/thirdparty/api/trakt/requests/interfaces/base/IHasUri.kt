package com.atherapp.thirdparty.api.trakt.requests.interfaces.base

interface IHasUri : IHasUriPathParameters {
    val uriTemplate: String
}
