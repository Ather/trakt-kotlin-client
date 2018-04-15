package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
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
            extendedInfo: TraktExtendedInfo? = null
    ): CompletableFuture<TraktResponse<TraktEpisode>> {
        return RequestHandler(client).executeSingleItemRequestAsync(EpisodeSummaryRequest(
                id = showIdOrSlug,
                seasonNumber = seasonNumber,
                episodeNumber = episodeNumber,
                extendedInfo = extendedInfo
        ))
    }

    fun getMultipleEpisodesAsync(
            episodesQueryParams: TraktMultipleEpisodesQueryParams
    ): CompletableFuture<List<TraktResponse<TraktEpisode>>> {
        if (episodesQueryParams.isEmpty())
            return CompletableFuture.completedFuture(listOf())

        var i = 0
        val tasks = Array(episodesQueryParams.size, {
            val queryParam = episodesQueryParams[i++]
            return@Array getEpisodeAsync(queryParam.showId, queryParam.seasonNumber, queryParam.episodeNumber, queryParam.extendedInfo)
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
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktComment>> {
        return RequestHandler(client).executePagedRequestAsync(EpisodeCommentsRequest(
                id = showIdOrSlug,
                seasonNumber = seasonNumber,
                episodeNumber = episodeNumber,
                sortOrder = commentSortOrder,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }

    fun getEpisodeListsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            listType: TraktListType? = null,
            listSortOrder: TraktListSortOrder? = null,
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktList>> {
        return RequestHandler(client).executePagedRequestAsync(EpisodeListsRequest(
                id = showIdOrSlug,
                seasonNumber = seasonNumber,
                episodeNumber = episodeNumber,
                type = listType,
                sortOrder = listSortOrder,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }

    fun getEpisodeRatingsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int
    ): CompletableFuture<TraktResponse<TraktRating>> {
        return RequestHandler(client).executeSingleItemRequestAsync(EpisodeRatingsRequest(
                id = showIdOrSlug,
                seasonNumber = seasonNumber,
                episodeNumber = episodeNumber
        ))
    }

    fun getEpisodeStatisticsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int
    ): CompletableFuture<TraktResponse<TraktStatistics>> {
        return RequestHandler(client).executeSingleItemRequestAsync(EpisodeStatisticsRequest(
                id = showIdOrSlug,
                seasonNumber = seasonNumber,
                episodeNumber = episodeNumber
        ))
    }

    fun getEpisodeTranslationsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            languageCode: String? = null
    ): CompletableFuture<TraktListResponse<TraktEpisodeTranslation>> {
        return RequestHandler(client).executeListRequestAsync(EpisodeTranslationsRequest(
                id = showIdOrSlug,
                seasonNumber = seasonNumber,
                episodeNumber = episodeNumber,
                languageCode = languageCode
        ))
    }

    fun getEpisodeWatchingUsersAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            episodeNumber: Int,
            extendedInfo: TraktExtendedInfo? = null
    ): CompletableFuture<TraktListResponse<TraktUser>> {
        return RequestHandler(client).executeListRequestAsync(EpisodeWatchingUsersRequest(
                id = showIdOrSlug,
                seasonNumber = seasonNumber,
                episodeNumber = episodeNumber,
                extendedInfo = extendedInfo
        ))
    }
}