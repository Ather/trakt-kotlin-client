package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
import media.thehoard.thirdparty.api.trakt.enums.TraktTimePeriod
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCastAndCrew
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktComment
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktRating
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktStatistics
import media.thehoard.thirdparty.api.trakt.objects.get.shows.*
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktShowFilter
import media.thehoard.thirdparty.api.trakt.requests.shows.*
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.time.ZonedDateTime
import java.util.concurrent.CompletableFuture

class TraktShowsModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getShowAsync(
            showIdOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktShow>> {
        return RequestHandler(client).executeSingleItemRequestAsync(ShowSummaryRequest(showIdOrSlug, extendedInfo), requestAuthorization)
    }

    fun getMultipleShowsAsync(
            showsQueryParams: TraktMultipleObjectsQueryParams,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<List<TraktResponse<TraktShow>>> {
        if (showsQueryParams.isEmpty())
            return CompletableFuture.completedFuture(listOf())

        var i = 0
        val tasks = Array(showsQueryParams.size, {
            val queryParam = showsQueryParams[i++]
            return@Array getShowAsync(queryParam.idOrSlug, queryParam.extendedInfo, requestAuthorization)
        })

        return CompletableFuture.supplyAsync {
            i = 0
            List(tasks.size, { tasks[i++].get() })
        }
    }

    fun getShowAliasesAsync(
            showIdOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktShowAlias>> {
        return RequestHandler(client).executeListRequestAsync(ShowAliasesRequest(showIdOrSlug), requestAuthorization)
    }

    fun getShowTranslationsAsync(
            showIdOrSlug: String,
            languageCode: String? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktShowTranslation>> {
        return RequestHandler(client).executeListRequestAsync(ShowTranslationsRequest(showIdOrSlug, languageCode), requestAuthorization)
    }

    fun getShowCommentsAsync(
            showIdOrSlug: String,
            commentSortOrder: TraktCommentSortOrder? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktComment>> {
        return RequestHandler(client).executePagedRequestAsync(ShowCommentsRequest(showIdOrSlug, commentSortOrder, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getShowListsAsync(
            showIdOrSlug: String,
            listType: TraktListType? = null,
            listSortOrder: TraktListSortOrder? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktList>> {
        return RequestHandler(client).executePagedRequestAsync(ShowListsRequest(showIdOrSlug, listType, listSortOrder, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getShowPeopleAsync(
            showIdOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktCastAndCrew>> {
        return RequestHandler(client).executeSingleItemRequestAsync(ShowPeopleRequest(showIdOrSlug, extendedInfo), requestAuthorization)
    }

    fun getShowRatingsAsync(
            showIdOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktRating>> {
        return RequestHandler(client).executeSingleItemRequestAsync(ShowRatingsRequest(showIdOrSlug), requestAuthorization)
    }

    fun getShowRelatedShowsAsync(
            showIdOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktShow>> {
        return RequestHandler(client).executePagedRequestAsync(ShowRelatedShowsRequest(showIdOrSlug, extendedInfo, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getShowStatisticsAsync(
            showIdOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktStatistics>> {
        return RequestHandler(client).executeSingleItemRequestAsync(ShowStatisticsRequest(showIdOrSlug), requestAuthorization)
    }

    fun getShowWatchingUsersAsync(
            showIdOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktUser>> {
        return RequestHandler(client).executeListRequestAsync(ShowWatchingUsersRequest(showIdOrSlug, extendedInfo), requestAuthorization)
    }

    fun getTrendingShowsAsync(
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktShowFilter? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktTrendingShow>> {
        return RequestHandler(client).executePagedRequestAsync(ShowsTrendingRequest(extendedInfo, filter, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getPopularShowsAsync(
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktShowFilter? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktShow>> {
        return RequestHandler(client).executePagedRequestAsync(ShowsPopularRequest(extendedInfo, filter, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getMostPlayedShowsAsync(
            period: TraktTimePeriod? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktShowFilter? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktMostPWCShow>> {
        return RequestHandler(client).executePagedRequestAsync(ShowsMostPlayedRequest(period, extendedInfo, filter, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getMostWatchedShowsAsync(
            period: TraktTimePeriod? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktShowFilter? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktMostPWCShow>> {
        return RequestHandler(client).executePagedRequestAsync(ShowsMostWatchedRequest(period, extendedInfo, filter, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getMostCollectedShowsAsync(
            period: TraktTimePeriod? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktShowFilter? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktMostPWCShow>> {
        return RequestHandler(client).executePagedRequestAsync(ShowsMostCollectedRequest(period, extendedInfo, filter, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getMostAnticipatedShowsAsync(
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktShowFilter? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktMostAnticipatedShow>> {
        return RequestHandler(client).executePagedRequestAsync(ShowsMostAnticipatedRequest(extendedInfo, filter, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getRecentlyUpdatedShowsAsync(
            startDate: ZonedDateTime? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktRecentlyUpdatedShow>> {
        return RequestHandler(client).executePagedRequestAsync(ShowsRecentlyUpdatedRequest(startDate, extendedInfo, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }
}
