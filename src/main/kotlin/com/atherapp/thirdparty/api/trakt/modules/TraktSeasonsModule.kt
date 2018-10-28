package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.enums.TraktCommentSortOrder
import com.atherapp.thirdparty.api.trakt.enums.TraktListSortOrder
import com.atherapp.thirdparty.api.trakt.enums.TraktListType
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktComment
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktRating
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktStatistics
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUser
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import com.atherapp.thirdparty.api.trakt.requests.seasons.*
import com.atherapp.thirdparty.api.trakt.responses.TraktListResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktPagedResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class TraktSeasonsModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getAllSeasonsAsync(
            showIdOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            translationLanguageCode: String? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktListResponse<TraktSeason>> {
        return RequestHandler(client).executeListRequestAsync(SeasonsAllRequest(showIdOrSlug, translationLanguageCode, extendedInfo), requestAuthorization)
    }

    fun getSeasonAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            extendedInfo: TraktExtendedInfo? = null,
            translationLanguageCode: String? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktListResponse<TraktEpisode>> {
        return RequestHandler(client).executeListRequestAsync(SeasonSingleRequest(showIdOrSlug, seasonNumber, translationLanguageCode, extendedInfo), requestAuthorization)
    }

    fun getMultipleSeasonsAsync(
            seasonsQueryParms: TraktMultipleSeasonsQueryParams,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<List<TraktListResponse<TraktEpisode>>> {
        if (seasonsQueryParms.isEmpty())
            return CompletableDeferred(listOf())

        var i = 0
        val tasks = Array(seasonsQueryParms.size) {
            val queryParam = seasonsQueryParms[i++]
            return@Array getSeasonAsync(queryParam.showId, queryParam.seasonNumber, queryParam.extendedInfo, queryParam.translationLanguageCode, requestAuthorization)
        }

        return GlobalScope.async { tasks.map { it.await() } }
    }

    fun getSeasonCommentsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            commentSortOrder: TraktCommentSortOrder? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktPagedResponse<TraktComment>> {
        return RequestHandler(client).executePagedRequestAsync(SeasonCommentsRequest(showIdOrSlug, seasonNumber, commentSortOrder, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getSeasonListsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            listType: TraktListType? = null,
            listSortOrder: TraktListSortOrder? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktPagedResponse<TraktList>> {
        return RequestHandler(client).executePagedRequestAsync(SeasonListsRequest(showIdOrSlug, seasonNumber, listType, listSortOrder, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getSeasonRatingsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktRating>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SeasonRatingsRequest(showIdOrSlug, seasonNumber), requestAuthorization)
    }

    fun getSeasonStatisticsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktStatistics>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SeasonStatisticsRequest(showIdOrSlug, seasonNumber), requestAuthorization)
    }

    fun getSeasonWatchingUsersAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktUser>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SeasonWatchingUsersRequest(showIdOrSlug, seasonNumber, extendedInfo), requestAuthorization)
    }
}
