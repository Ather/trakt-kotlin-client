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
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeTranslation
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUser
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList
import com.atherapp.thirdparty.api.trakt.requests.episodes.*
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import com.atherapp.thirdparty.api.trakt.responses.TraktListResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktPagedResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class TraktEpisodesModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getEpisodeAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktEpisode>> {
        return RequestHandler(client).executeSingleItemRequestAsync(EpisodeSummaryRequest(
                showIdOrSlug, seasonNumber, episodeNumber, extendedInfo
        ), requestAuthorization)
    }

    fun getMultipleEpisodesAsync(
            episodesQueryParams: TraktMultipleEpisodesQueryParams,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<List<TraktResponse<TraktEpisode>>> {
        if (episodesQueryParams.isEmpty())
            return CompletableDeferred(listOf())

        var i = 0
        val tasks = Array(episodesQueryParams.size) {
            val queryParam = episodesQueryParams[i++]
            return@Array getEpisodeAsync(queryParam.showId, queryParam.seasonNumber, queryParam.episodeNumber, queryParam.extendedInfo, requestAuthorization)
        }

        return GlobalScope.async { tasks.map { it.await() } }
    }

    fun getEpisodeCommentsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            commentSortOrder: TraktCommentSortOrder? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktPagedResponse<TraktComment>> {
        return RequestHandler(client).executePagedRequestAsync(EpisodeCommentsRequest(
                showIdOrSlug, seasonNumber, episodeNumber, commentSortOrder, pagedParameters?.page, pagedParameters?.limit
        ), requestAuthorization)
    }

    fun getEpisodeListsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            listType: TraktListType? = null,
            listSortOrder: TraktListSortOrder? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktPagedResponse<TraktList>> {
        return RequestHandler(client).executePagedRequestAsync(EpisodeListsRequest(
                showIdOrSlug, seasonNumber, episodeNumber, listType, listSortOrder, pagedParameters?.page, pagedParameters?.limit
        ), requestAuthorization)
    }

    fun getEpisodeRatingsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktRating>> {
        return RequestHandler(client).executeSingleItemRequestAsync(EpisodeRatingsRequest(
                showIdOrSlug, seasonNumber, episodeNumber
        ), requestAuthorization)
    }

    fun getEpisodeStatisticsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktStatistics>> {
        return RequestHandler(client).executeSingleItemRequestAsync(EpisodeStatisticsRequest(
                showIdOrSlug, seasonNumber, episodeNumber
        ), requestAuthorization)
    }

    fun getEpisodeTranslationsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            languageCode: String? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktListResponse<TraktEpisodeTranslation>> {
        return RequestHandler(client).executeListRequestAsync(EpisodeTranslationsRequest(
                showIdOrSlug, seasonNumber, episodeNumber, languageCode
        ), requestAuthorization)
    }

    fun getEpisodeWatchingUsersAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktListResponse<TraktUser>> {
        return RequestHandler(client).executeListRequestAsync(EpisodeWatchingUsersRequest(
                showIdOrSlug, seasonNumber, episodeNumber, extendedInfo
        ), requestAuthorization)
    }
}