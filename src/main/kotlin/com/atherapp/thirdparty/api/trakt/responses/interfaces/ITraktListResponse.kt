package com.atherapp.thirdparty.api.trakt.responses.interfaces

interface ITraktListResponse<TResponseContentType> : ITraktResponse<MutableList<TResponseContentType>>, MutableList<TResponseContentType>