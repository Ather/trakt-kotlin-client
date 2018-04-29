package com.atherapp.thirdparty.api.trakt.requests.interfaces.base

import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody

internal interface IPutRequest<TRequestBodyType : IRequestBody> : IRequest, IHasRequestBody<TRequestBodyType>
