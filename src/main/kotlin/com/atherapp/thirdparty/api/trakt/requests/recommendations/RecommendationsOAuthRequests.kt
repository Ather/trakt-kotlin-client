package com.atherapp.thirdparty.api.trakt.requests.recommendations

import com.atherapp.thirdparty.api.trakt.extensions.isValidStringId
import com.atherapp.thirdparty.api.trakt.extensions.validate
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.requests.base.ADeleteRequest
import com.atherapp.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import com.atherapp.thirdparty.api.trakt.requests.base.AuthorizationRequirement
import com.atherapp.thirdparty.api.trakt.requests.base.RequestObjectType
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IHasId
import com.atherapp.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import kotlin.reflect.KClass

internal sealed class AUserRecommendationHideRequest(
        override val uriTemplate: String,
        override val requestObjectType: RequestObjectType
) : ADeleteRequest(), IHasId {
    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate(variableName: String) = id.validate("id or slug", ::isValidStringId)
}

internal sealed class AUserRecommendationsRequest<TResponseContentType : Any>(
        override val uriTemplate: String,
        override var extendedInfo: TraktExtendedInfo?,
        var limit: Int? = null,
        responseContentClass: KClass<TResponseContentType>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), ISupportsExtendedInfo {
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
        override var extendedInfo: TraktExtendedInfo?,
        limit: Int?
) : AUserRecommendationsRequest<TraktMovie>(
        "recommendations/movies{?extended,limit}",
        extendedInfo,
        limit,
        TraktMovie::class
) {
    override fun validate(variableName: String) {}
}

internal class UserRecommendationHideMovieRequest(
        override var id: String
) : AUserRecommendationHideRequest(
        "recommendations/movies/{id}",
        RequestObjectType.Movies
)

internal class UserRecommendationHideShowRequest(
        override var id: String
) : AUserRecommendationHideRequest(
        "recommendations/shows/{id}",
        RequestObjectType.Shows
)

internal class UserShowRecommendationsRequest(
        override var extendedInfo: TraktExtendedInfo?,
        limit: Int?
) : AUserRecommendationsRequest<TraktShow>(
        "recommendations/shows{?extended,limit}",
        extendedInfo,
        limit,
        TraktShow::class
) {
    override fun validate(variableName: String) {}
}