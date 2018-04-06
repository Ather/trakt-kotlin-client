package media.thehoard.thirdparty.api.trakt.requests.genres

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktGenreImpl
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse

internal class GenresMovieRequest : AGetRequestHasResponse<TraktGenreImpl>(TraktGenreImpl::class) {
    override val uriTemplate: String = "genres/movies"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()

    override fun validate() {}
}

internal class GenresShowRequest : AGetRequestHasResponse<TraktGenreImpl>(TraktGenreImpl::class) {
    override val uriTemplate: String = "genres/shows"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()

    override fun validate() {}
}