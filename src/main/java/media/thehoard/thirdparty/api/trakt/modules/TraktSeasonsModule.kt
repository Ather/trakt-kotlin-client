package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktComment
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktRating
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktStatistics
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import media.thehoard.thirdparty.api.trakt.requests.seasons.*
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.util.concurrent.CompletableFuture

class TraktSeasonsModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getAllSeasonsAsync(
            showIdOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            translationLanguageCode: String? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktSeason>> {
        return RequestHandler(client).executeListRequestAsync(SeasonsAllRequest(showIdOrSlug, translationLanguageCode, extendedInfo), requestAuthorization)
    }

    fun getSeasonAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            extendedInfo: TraktExtendedInfo? = null,
            translationLanguageCode: String? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktEpisode>> {
        return RequestHandler(client).executeListRequestAsync(SeasonSingleRequest(showIdOrSlug, seasonNumber, translationLanguageCode, extendedInfo), requestAuthorization)
    }

    fun getMultipleSeasonsAsync(
            seasonsQueryParms: TraktMultipleSeasonsQueryParams,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<List<TraktListResponse<TraktEpisode>>> {
        if (seasonsQueryParms.isEmpty())
            return CompletableFuture.completedFuture(listOf())

        var i = 0
        val tasks = Array(seasonsQueryParms.size, {
            val queryParam = seasonsQueryParms[i++]
            return@Array getSeasonAsync(queryParam.showId, queryParam.seasonNumber, queryParam.extendedInfo, queryParam.translationLanguageCode, requestAuthorization)
        })

        return CompletableFuture.supplyAsync {
            i = 0
            List(tasks.size, { tasks[i++].get() })
        }
    }

    fun getSeasonCommentsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            commentSortOrder: TraktCommentSortOrder? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktComment>> {
        return RequestHandler(client).executePagedRequestAsync(SeasonCommentsRequest(showIdOrSlug, seasonNumber, commentSortOrder, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getSeasonListsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            listType: TraktListType? = null,
            listSortOrder: TraktListSortOrder? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktList>> {
        return RequestHandler(client).executePagedRequestAsync(SeasonListsRequest(showIdOrSlug, seasonNumber, listType, listSortOrder, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getSeasonRatingsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktRating>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SeasonRatingsRequest(showIdOrSlug, seasonNumber), requestAuthorization)
    }

    fun getSeasonStatisticsAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktStatistics>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SeasonStatisticsRequest(showIdOrSlug, seasonNumber), requestAuthorization)
    }

    fun getSeasonWatchingUsersAsync(
            showIdOrSlug: String,
            seasonNumber: Int,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktUser>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SeasonWatchingUsersRequest(showIdOrSlug, seasonNumber, extendedInfo), requestAuthorization)
    }
}
