package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.recommendations.UserMovieRecommendationsRequest
import media.thehoard.thirdparty.api.trakt.requests.recommendations.UserRecommendationHideMovieRequest
import media.thehoard.thirdparty.api.trakt.requests.recommendations.UserRecommendationHideShowRequest
import media.thehoard.thirdparty.api.trakt.requests.recommendations.UserShowRecommendationsRequest
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import java.util.concurrent.CompletableFuture

class TraktRecommendationsModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getMovieRecommendationsAsync(
            limit: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktMovie>> {
        return RequestHandler(client).executePagedRequestAsync(UserMovieRecommendationsRequest(extendedInfo, limit), requestAuthorization)
    }
    
    fun hideMovieRecommendationAsync(
            movieIdOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktNoContentResponse> {
        return RequestHandler(client).executeNoContentRequestAsync(UserRecommendationHideMovieRequest(movieIdOrSlug), requestAuthorization)
    }

    fun getShowRecommendationsAsync(
            limit: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktShow>> {
        return RequestHandler(client).executePagedRequestAsync(UserShowRecommendationsRequest(extendedInfo, limit), requestAuthorization)
    }

    fun hideShowRecommendationAsync(
            showIdOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktNoContentResponse> {
        return RequestHandler(client).executeNoContentRequestAsync(UserRecommendationHideShowRequest(showIdOrSlug), requestAuthorization)
    }
}
