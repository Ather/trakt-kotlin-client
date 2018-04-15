package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
import media.thehoard.thirdparty.api.trakt.enums.TraktTimePeriod
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCastAndCrew
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktComment
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktRating
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktStatistics
import media.thehoard.thirdparty.api.trakt.objects.get.movies.*
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.requests.movies.*
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktMovieFilter
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.time.ZonedDateTime
import java.util.concurrent.CompletableFuture

class TraktMoviesModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getMovieAsync(
            movieIdOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null
    ): CompletableFuture<TraktResponse<TraktMovie>> {
        return RequestHandler(client).executeSingleItemRequestAsync(MovieSummaryRequest(
                id = movieIdOrSlug,
                extendedInfo = extendedInfo
        ))
    }

    fun getMultipleMoviesAsync(
            moviesQueryParams: TraktMultipleObjectsQueryParams
    ): CompletableFuture<List<TraktResponse<TraktMovie>>> {
        if (moviesQueryParams.isEmpty())
            return CompletableFuture.completedFuture(listOf())

        var i = 0
        val tasks = Array(moviesQueryParams.size, {
            val queryParam = moviesQueryParams[i++]
            return@Array getMovieAsync(queryParam.idOrSlug, queryParam.extendedInfo)
        })

        return CompletableFuture.supplyAsync {
            i = 0
            List(tasks.size, { tasks[i++].get() })
        }
    }

    fun getMovieAliasesAsync(
            movieIdOrSlug: String
    ): CompletableFuture<TraktListResponse<TraktMovieAlias>> {
        return RequestHandler(client).executeListRequestAsync(MovieAliasesRequest(
                id = movieIdOrSlug
        ))
    }

    fun getMovieReleasesAsync(
            movieIdOrSlug: String,
            countryCode: String? = null
    ): CompletableFuture<TraktListResponse<TraktMovieRelease>> {
        return RequestHandler(client).executeListRequestAsync(MovieReleasesRequest(
                id = movieIdOrSlug,
                countryCode = countryCode
        ))
    }

    fun getMovieTranslationsAsync(
            movieIdOrSlug: String,
            languageCode: String? = null
    ): CompletableFuture<TraktListResponse<TraktMovieTranslation>> {
        return RequestHandler(client).executeListRequestAsync(MovieTranslationsRequest(
                id = movieIdOrSlug,
                languageCode = languageCode
        ))
    }

    fun getMovieCommentsAsync(
            movieIdOrSlug: String,
            commentSortOrder: TraktCommentSortOrder? = null,
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktComment>> {
        return RequestHandler(client).executePagedRequestAsync(MovieCommentsRequest(
                id = movieIdOrSlug,
                sortOrder = commentSortOrder,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }

    fun getMovieListsAsync(
            movieIdOrSlug: String,
            listType: TraktListType? = null,
            listSortOrder: TraktListSortOrder? = null,
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktList>> {
        return RequestHandler(client).executePagedRequestAsync(MovieListsRequest(
                id = movieIdOrSlug,
                type = listType,
                sortOrder = listSortOrder,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }

    fun getMoviePeopleAsync(
            movieIdOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null
    ): CompletableFuture<TraktResponse<TraktCastAndCrew>> {
        return RequestHandler(client).executeSingleItemRequestAsync(MoviePeopleRequest(
                id = movieIdOrSlug,
                extendedInfo = extendedInfo
        ))
    }

    fun getMovieRatingsAsync(
            movieIdOrSlug: String
    ): CompletableFuture<TraktResponse<TraktRating>> {
        return RequestHandler(client).executeSingleItemRequestAsync(MovieRatingsRequest(
                id = movieIdOrSlug
        ))
    }

    fun getMovieRelatedMoviesAsync(
            movieIdOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktMovie>> {
        return RequestHandler(client).executePagedRequestAsync(MovieRelatedMoviesRequest(
                id = movieIdOrSlug,
                extendedInfo = extendedInfo,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }

    fun getMovieStatisticsAsync(
            movieIdOrSlug: String
    ): CompletableFuture<TraktResponse<TraktStatistics>> {
        return RequestHandler(client).executeSingleItemRequestAsync(MovieStatisticsRequest(
                id = movieIdOrSlug
        ))
    }

    fun getMovieWatchingUsersAsync(
            movieIdOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null
    ): CompletableFuture<TraktListResponse<TraktUser>> {
        return RequestHandler(client).executeListRequestAsync(MovieWatchingUsersRequest(
                id = movieIdOrSlug,
                extendedInfo = extendedInfo
        ))
    }

    fun getTrendingMoviesAsync(
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktMovieFilter? = null,
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktTrendingMovie>> {
        return RequestHandler(client).executePagedRequestAsync(MoviesTrendingRequest(
                extendedInfo = extendedInfo,
                filter = filter,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }

    fun getPopularMoviesAsync(
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktMovieFilter? = null,
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktMovie>> {
        return RequestHandler(client).executePagedRequestAsync(MoviesPopularRequest(
                extendedInfo = extendedInfo,
                filter = filter,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }

    fun getMostPlayedMoviesAsync(
            period: TraktTimePeriod? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktMovieFilter? = null,
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktMostPWCMovie>> {
        return RequestHandler(client).executePagedRequestAsync(MoviesMostPlayedRequest(
                period = period,
                extendedInfo = extendedInfo,
                filter = filter,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }

    fun getMostWatchedMoviesAsync(
            period: TraktTimePeriod? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktMovieFilter? = null,
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktMostPWCMovie>> {
        return RequestHandler(client).executePagedRequestAsync(MoviesMostWatchedRequest(
                period = period,
                extendedInfo = extendedInfo,
                filter = filter,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }

    fun getMostCollectedMoviesAsync(
            period: TraktTimePeriod? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktMovieFilter? = null,
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktMostPWCMovie>> {
        return RequestHandler(client).executePagedRequestAsync(MoviesMostCollectedRequest(
                period = period,
                extendedInfo = extendedInfo,
                filter = filter,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }

    fun getMostAnticipatedMoviesAsync(
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktMovieFilter? = null,
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktMostAnticipatedMovie>> {
        return RequestHandler(client).executePagedRequestAsync(MoviesMostAnticipatedRequest(
                extendedInfo = extendedInfo,
                filter = filter,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }

    fun getBoxOfficeMoviesAsync(
            extendedInfo: TraktExtendedInfo? = null
    ): CompletableFuture<TraktListResponse<TraktBoxOfficeMovie>> {
        return RequestHandler(client).executeListRequestAsync(MoviesBoxOfficeRequest(
                extendedInfo = extendedInfo
        ))
    }

    fun getRecentlyUpdatedMoviesAsync(
            startDate: ZonedDateTime? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktRecentlyUpdatedMovie>> {
        return RequestHandler(client).executePagedRequestAsync(MoviesRecentlyUpdatedRequest(
                startDate = startDate,
                extendedInfo = extendedInfo,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }
}
