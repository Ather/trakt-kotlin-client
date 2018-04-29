package com.atherapp.thirdparty.api.trakt.requests.interfaces.base

import com.atherapp.thirdparty.api.trakt.requests.interfaces.IValidatable

internal interface IRequest : IHttpRequest, IHasRequestAuthorization, IHasUri, IValidatable
