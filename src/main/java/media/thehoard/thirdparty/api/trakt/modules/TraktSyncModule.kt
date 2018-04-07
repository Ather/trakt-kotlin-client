package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.enums.TraktRatingsItemType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncItemType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType
import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.history.implementations.TraktHistoryItemImpl
import media.thehoard.thirdparty.api.trakt.objects.get.ratings.implementations.TraktRatingsItemImpl
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations.TraktSyncLastActivitiesImpl
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.playback.implementations.TraktSyncPlaybackProgressItemImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watchlist.implementations.TraktWatchlistItemImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPost
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations.TraktSyncCollectionPostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.responses.implementations.TraktSyncCollectionPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.responses.implementations.TraktSyncCollectionRemovePostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPost
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations.TraktSyncHistoryPostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations.TraktSyncHistoryRemovePostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations.TraktSyncHistoryPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations.TraktSyncHistoryRemovePostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations.TraktSyncRatingsPostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations.TraktSyncRatingsPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations.TraktSyncRatingsRemovePostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations.TraktSyncWatchlistPostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.implementations.TraktSyncWatchlistPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.implementations.TraktSyncWatchlistRemovePostResponseImpl
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import media.thehoard.thirdparty.api.trakt.requests.syncs.*
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.time.ZonedDateTime
import java.util.concurrent.CompletableFuture

class TraktSyncModule(override val client: TraktClient) : TraktModule {

    fun getLastActivitiesAsync(requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktResponse<TraktSyncLastActivitiesImpl>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SyncLastActivitiesRequest(), requestAuthorization)
    }

    fun getPlaybackProgressAsync(
            objectType: TraktSyncType? = null,
            limit: Int? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktSyncPlaybackProgressItemImpl>> {
        return RequestHandler(client).executeListRequestAsync(SyncPlaybackProgressRequest(objectType, limit), requestAuthorization)
    }

    fun removePlaybackItemAsync(
            playbackId: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktNoContentResponse> {
        if (playbackId <= 0)
            throw IllegalArgumentException("playback id not valid")

        return RequestHandler(client).executeNoContentRequestAsync(SyncPlaybackDeleteRequest(id = playbackId.toString()), requestAuthorization)
    }

    fun getCollectionMoviesAsync(
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktCollectionMovieImpl>> {
        return RequestHandler(client).executeListRequestAsync(SyncCollectionMoviesRequest(extendedInfo), requestAuthorization)
    }

    fun getCollectionShowsAsync(
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktCollectionShowImpl>> {
        return RequestHandler(client).executeListRequestAsync(SyncCollectionShowsRequest(extendedInfo), requestAuthorization)
    }

    fun addCollectionItemsAsync(
            collectionPost: TraktSyncCollectionPostImpl,
            requestAuthorization: TraktAuthorization
    ): CompletableFuture<TraktResponse<TraktSyncCollectionPostResponseImpl>> {
        validateCollectionPost(collectionPost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncCollectionAddRequest(requestBody = collectionPost), requestAuthorization)
    }

    fun removeCollectionItemsAsync(
            collectionRemovePost: TraktSyncCollectionPostImpl,
            requestAuthorization: TraktAuthorization
    ): CompletableFuture<TraktResponse<TraktSyncCollectionRemovePostResponseImpl>> {
        validateCollectionPost(collectionRemovePost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncCollectionRemoveRequest(requestBody = collectionRemovePost), requestAuthorization)
    }

    fun getWatchedMoviesAsync(
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization
    ): CompletableFuture<TraktListResponse<TraktWatchedMovieImpl>> {
        return RequestHandler(client).executeListRequestAsync(SyncWatchedMoviesRequest(extendedInfo), requestAuthorization)
    }

    fun getWatchedShowsAsync(
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization
    ): CompletableFuture<TraktListResponse<TraktWatchedShowImpl>> {
        return RequestHandler(client).executeListRequestAsync(SyncWatchedShowsRequest(extendedInfo), requestAuthorization)
    }

    fun getWatchedHistoryAsync(
            historyItemType: TraktSyncItemType? = null,
            itemId: Int? = null,
            startAt: ZonedDateTime? = null,
            endAt: ZonedDateTime? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktHistoryItemImpl>> {
        return RequestHandler(client).executePagedRequestAsync(SyncWatchedHistoryRequest(
                type = historyItemType,
                itemId = itemId,
                startAt = startAt,
                endAt = endAt,
                extendedInfo = extendedInfo,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ), requestAuthorization)
    }

    fun addWatchedHistoryItemsAsync(
            historyPost: TraktSyncHistoryPostImpl,
            requestAuthorization: TraktAuthorization
    ): CompletableFuture<TraktResponse<TraktSyncHistoryPostResponseImpl>> {
        validateHistoryPost(historyPost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncWatchedHistoryAddRequest(requestBody = historyPost), requestAuthorization)
    }

    fun removeWatchedHistoryItemsAsync(
            historyRemovePost: TraktSyncHistoryRemovePostImpl,
            requestAuthorization: TraktAuthorization
    ): CompletableFuture<TraktResponse<TraktSyncHistoryRemovePostResponseImpl>> {
        validateHistoryPost(historyRemovePost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncWatchedHistoryRemoveRequest(requestBody = historyRemovePost), requestAuthorization)
    }

    fun getRatingsAsync(
            ratingsItemType: TraktRatingsItemType? = null,
            ratingsFilter: List<Int>? = null,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktRatingsItemImpl>> {
        return RequestHandler(client).executeListRequestAsync(SyncRatingsRequest(
                type = ratingsItemType,
                ratingFilter = ratingsFilter,
                extendedInfo = extendedInfo
        ), requestAuthorization)
    }

    fun addRatingsAsync(
            ratingsPost: TraktSyncRatingsPostImpl,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktSyncRatingsPostResponseImpl>> {
        validateRatingsPost(ratingsPost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncRatingsAddRequest(requestBody = ratingsPost), requestAuthorization)
    }

    fun removeRatingsAsync(
            ratingsRemovePost: TraktSyncRatingsPostImpl,
            requestAuthorization: TraktAuthorization
    ): CompletableFuture<TraktResponse<TraktSyncRatingsRemovePostResponseImpl>> {
        validateRatingsPost(ratingsRemovePost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncRatingsRemoveRequest(requestBody = ratingsRemovePost), requestAuthorization)
    }

    fun getWatchlistAsync(
            watchlistItemType: TraktSyncItemType? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktWatchlistItemImpl>> {
        return RequestHandler(client).executePagedRequestAsync(SyncWatchlistRequest(
                type = watchlistItemType,
                extendedInfo = extendedInfo,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ), requestAuthorization)
    }

    fun addWatchlistItemsAsync(
            watchlistPost: TraktSyncWatchlistPostImpl,
            requestAuthorization: TraktAuthorization
    ): CompletableFuture<TraktResponse<TraktSyncWatchlistPostResponseImpl>> {
        validateWatchlistPost(watchlistPost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncWatchlistAddRequest(requestBody = watchlistPost), requestAuthorization)
    }

    fun removeWatchlistItemsAsync(
            watchlistRemovePost: TraktSyncWatchlistPostImpl,
            requestAuthorization: TraktAuthorization
    ): CompletableFuture<TraktResponse<TraktSyncWatchlistRemovePostResponseImpl>> {
        validateWatchlistPost(watchlistRemovePost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncWatchlistRemoveRequest(requestBody = watchlistRemovePost), requestAuthorization)
    }

    private fun validateCollectionPost(collectionPost: TraktSyncCollectionPost) {
        if (collectionPost.movies.isEmpty() && collectionPost.shows.isEmpty() && collectionPost.episodes.isEmpty())
            throw IllegalArgumentException("no collection items set")
    }

    private fun validateHistoryPost(historyPost: TraktSyncHistoryPost) {
        if (historyPost.movies.isEmpty() && historyPost.shows.isEmpty() && historyPost.episodes.isEmpty())
            throw IllegalArgumentException("no history items set")
    }

    private fun validateRatingsPost(ratingsPost: TraktSyncRatingsPostImpl) {
        if (ratingsPost.movies.isEmpty() && ratingsPost.shows.isEmpty() && ratingsPost.episodes.isEmpty())
            throw IllegalArgumentException("no ratings items set")
    }

    private fun validateWatchlistPost(watchlistPost: TraktSyncWatchlistPostImpl) {
        if (watchlistPost.movies.isEmpty() && watchlistPost.shows.isEmpty() && watchlistPost.episodes.isEmpty())
            throw IllegalArgumentException("no watchlist items set")
    }
}
