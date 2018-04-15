package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
import media.thehoard.thirdparty.api.trakt.extensions.isNotNegative
import media.thehoard.thirdparty.api.trakt.extensions.isPositive
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktComment
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktRating
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktStatistics
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeTranslation
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList
import media.thehoard.thirdparty.api.trakt.requests.episodes.*
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.util.concurrent.CompletableFuture

class TraktEpisodesModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getEpisodeAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktEpisode>> {
        seasonNumber.validate("season number", ::isNotNegative)
        episodeNumber.validate("episode number", ::isPositive)

        return RequestHandler(client).executeSingleItemRequestAsync(EpisodeSummaryRequest(
                showIdOrSlug, seasonNumber, episodeNumber, extendedInfo
        ), requestAuthorization)
    }

    fun getMultipleEpisodesAsync(
            episodesQueryParams: TraktMultipleEpisodesQueryParams,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<List<TraktResponse<TraktEpisode>>> {
        if (episodesQueryParams.isEmpty())
            return CompletableFuture.completedFuture(listOf())

        var i = 0
        val tasks = Array(episodesQueryParams.size, {
            val queryParam = episodesQueryParams[i++]
            return@Array getEpisodeAsync(queryParam.showId, queryParam.seasonNumber, queryParam.episodeNumber, queryParam.extendedInfo, requestAuthorization)
        })

        return CompletableFuture.supplyAsync {
            i = 0
            List(tasks.size, { tasks[i++].get() })
        }
    }

    fun getEpisodeCommentsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            commentSortOrder: TraktCommentSortOrder? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktComment>> {
        seasonNumber.validate("season number", ::isNotNegative)
        episodeNumber.validate("episode number", ::isPositive)

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
    ): CompletableFuture<TraktPagedResponse<TraktList>> {
        seasonNumber.validate("season number", ::isNotNegative)
        episodeNumber.validate("episode number", ::isPositive)

        return RequestHandler(client).executePagedRequestAsync(EpisodeListsRequest(
                showIdOrSlug, seasonNumber, episodeNumber, listType, listSortOrder, pagedParameters?.page, pagedParameters?.limit
        ), requestAuthorization)
    }

    fun getEpisodeRatingsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktRating>> {
        seasonNumber.validate("season number", ::isNotNegative)
        episodeNumber.validate("episode number", ::isPositive)

        return RequestHandler(client).executeSingleItemRequestAsync(EpisodeRatingsRequest(
                showIdOrSlug, seasonNumber, episodeNumber
        ), requestAuthorization)
    }

    fun getEpisodeStatisticsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktStatistics>> {
        seasonNumber.validate("season number", ::isNotNegative)
        episodeNumber.validate("episode number", ::isPositive)

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
    ): CompletableFuture<TraktListResponse<TraktEpisodeTranslation>> {
        seasonNumber.validate("season number", ::isNotNegative)
        episodeNumber.validate("episode number", ::isPositive)

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
    ): CompletableFuture<TraktListResponse<TraktUser>> {
        seasonNumber.validate("season number", ::isNotNegative)
        episodeNumber.validate("episode number", ::isPositive)

        return RequestHandler(client).executeListRequestAsync(EpisodeWatchingUsersRequest(
                showIdOrSlug, seasonNumber, episodeNumber, extendedInfo
        ), requestAuthorization)
    }
}