package com.atherapp.thirdparty.api.trakt.requests.interfaces.base

interface IHasRequestBody<TRequestBodyType> {
    var requestBody: TRequestBodyType?
}
