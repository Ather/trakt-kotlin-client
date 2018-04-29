package com.atherapp.thirdparty.api.trakt.requests.genres

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktGenre
import com.atherapp.thirdparty.api.trakt.requests.base.AGetRequestHasResponse

internal class GenresMoviesRequest : AGetRequestHasResponse<TraktGenre>(TraktGenre::class) {
    override val uriTemplate: String = "genres/movies"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()

    override fun validate(variableName: String) {}
}

internal class GenresShowsRequest : AGetRequestHasResponse<TraktGenre>(TraktGenre::class) {
    override val uriTemplate: String = "genres/shows"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()

    override fun validate(variableName: String) {}
}