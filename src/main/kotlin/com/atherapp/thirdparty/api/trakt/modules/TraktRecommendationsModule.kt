package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import com.atherapp.thirdparty.api.trakt.requests.recommendations.UserMovieRecommendationsRequest
import com.atherapp.thirdparty.api.trakt.requests.recommendations.UserRecommendationHideMovieRequest
import com.atherapp.thirdparty.api.trakt.requests.recommendations.UserRecommendationHideShowRequest
import com.atherapp.thirdparty.api.trakt.requests.recommendations.UserShowRecommendationsRequest
import com.atherapp.thirdparty.api.trakt.responses.TraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktPagedResponse
import kotlinx.coroutines.Deferred

class TraktRecommendationsModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getMovieRecommendationsAsync(
            limit: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktPagedResponse<TraktMovie>> {
        return RequestHandler(client).executePagedRequestAsync(UserMovieRecommendationsRequest(extendedInfo, limit), requestAuthorization)
    }

    fun hideMovieRecommendationAsync(
            movieIdOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktNoContentResponse> {
        return RequestHandler(client).executeNoContentRequestAsync(UserRecommendationHideMovieRequest(movieIdOrSlug), requestAuthorization)
    }

    fun getShowRecommendationsAsync(
            limit: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktPagedResponse<TraktShow>> {
        return RequestHandler(client).executePagedRequestAsync(UserShowRecommendationsRequest(extendedInfo, limit), requestAuthorization)
    }

    fun hideShowRecommendationAsync(
            showIdOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktNoContentResponse> {
        return RequestHandler(client).executeNoContentRequestAsync(UserRecommendationHideShowRequest(showIdOrSlug), requestAuthorization)
    }
}
