package com.atherapp.thirdparty.api.trakt.requests.interfaces.base

import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody

internal interface IPutRequestHasResponse<TResponseContentType : Any, TRequestBodyType : IRequestBody> : IRequestHasResponse<TResponseContentType>, IHasRequestBody<TRequestBodyType>
