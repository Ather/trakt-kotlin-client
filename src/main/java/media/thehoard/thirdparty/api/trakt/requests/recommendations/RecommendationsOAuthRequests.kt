package media.thehoard.thirdparty.api.trakt.requests.recommendations

import media.thehoard.thirdparty.api.trakt.extensions.containsSpace
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.requests.base.ADeleteRequest
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.base.AuthorizationRequirement
import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo

internal sealed class AUserRecommendationHideRequest(
        override val uriTemplate: String,
        override var id: String,
        override val requestObjectType: RequestObjectType
) : ADeleteRequest(), IHasId {
    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate() {
        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("id or slug not valid")
    }
}

internal sealed class AUserRecommendationsRequest<TResponseContentType>(
        override val uriTemplate: String,
        override var extendedInfo: TraktExtendedInfo? = null,
        var limit: Int? = null
) : AGetRequestHasResponse<TResponseContentType>(), ISupportsExtendedInfo {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf<String, String>().apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
            if (limit != null)
                this["limit"] = limit!!.toString()
        }
}

internal class UserMovieRecommendationsRequest(
        override var extendedInfo: TraktExtendedInfo? = null
) : AUserRecommendationsRequest<TraktMovieImpl>(
        "recommendations/movies{?extended,limit}",
        extendedInfo
) {
    override fun validate() {}
}

internal class UserRecommendationHideMovieRequest(
        override var id: String
) : AUserRecommendationHideRequest(
        "recommendations/movies/{id}",
        id,
        RequestObjectType.Movies
)

internal class UserRecommendationHideShowRequest(
        override var id: String
) : AUserRecommendationHideRequest(
        "recommendations/shows/{id}",
        id,
        RequestObjectType.Shows
)

internal class UserShowRecommendationsRequest(
        override var extendedInfo: TraktExtendedInfo? = null
) : AUserRecommendationsRequest<TraktShowImpl>(
        "recommendations/shows{?extended,limit}",
        extendedInfo
) {
    override fun validate() {}
}