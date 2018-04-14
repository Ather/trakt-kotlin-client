package media.thehoard.thirdparty.api.trakt.requests.genres

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktGenre
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse

internal class GenresMovieRequest : AGetRequestHasResponse<TraktGenre>(TraktGenre::class) {
    override val uriTemplate: String = "genres/movies"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()

    override fun validate(variableName: String) {}
}

internal class GenresShowRequest : AGetRequestHasResponse<TraktGenre>(TraktGenre::class) {
    override val uriTemplate: String = "genres/shows"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()

    override fun validate(variableName: String) {}
}