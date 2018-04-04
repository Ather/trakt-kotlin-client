package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.enums.TraktRatingsItemType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncItemType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType
import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionMovieExtendedMetadataImpl
import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionShowEpisodeExtendedMetadataImpl
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
import java.time.Instant
import java.util.concurrent.CompletableFuture

class TraktSyncModule(override val client: TraktClient) : TraktModule {

    fun getLastActivitiesAsync(): CompletableFuture<TraktResponse<TraktSyncLastActivitiesImpl>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SyncLastActivitiesRequest())
    }

    fun getPlaybackProgressAsync(
            objectType: TraktSyncType? = null,
            limit: Int? = null
    ): CompletableFuture<TraktListResponse<TraktSyncPlaybackProgressItemImpl>> {
        return RequestHandler(client).executeListRequestAsync(SyncPlaybackProgressRequest(objectType, limit))
    }

    fun removePlaybackItemAsync(playbackId: Int): CompletableFuture<TraktNoContentResponse> {
        if (playbackId <= 0)
            throw IllegalArgumentException("playback id not valid")

        return RequestHandler(client).executeNoContentRequestAsync(SyncPlaybackDeleteRequest(id = playbackId.toString()))
    }

    fun getCollectionMoviesAsync(extendedInfo: TraktExtendedInfo? = null): CompletableFuture<TraktListResponse<TraktCollectionMovieExtendedMetadataImpl>> {
        return RequestHandler(client).executeListRequestAsync(SyncCollectionMoviesRequest(extendedInfo))
    }

    fun getCollectionShowsAsync(extendedInfo: TraktExtendedInfo? = null): CompletableFuture<TraktListResponse<TraktCollectionShowImpl<TraktCollectionShowEpisodeExtendedMetadataImpl>>> {
        return RequestHandler(client).executeListRequestAsync(SyncCollectionShowsRequest(extendedInfo))
    }

    fun addCollectionItemsAsync(collectionPost: TraktSyncCollectionPostImpl): CompletableFuture<TraktResponse<TraktSyncCollectionPostResponseImpl>> {
        validateCollectionPost(collectionPost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncCollectionAddRequest(requestBody = collectionPost))
    }

    fun removeCollectionItemsAsync(collectionRemovePost: TraktSyncCollectionPostImpl): CompletableFuture<TraktResponse<TraktSyncCollectionRemovePostResponseImpl>> {
        validateCollectionPost(collectionRemovePost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncCollectionRemoveRequest(requestBody = collectionRemovePost))
    }

    fun getWatchedMoviesAsync(extendedInfo: TraktExtendedInfo? = null): CompletableFuture<TraktListResponse<TraktWatchedMovieImpl>> {
        return RequestHandler(client).executeListRequestAsync(SyncWatchedMoviesRequest(extendedInfo))
    }

    fun getWatchedShowsAsync(extendedInfo: TraktExtendedInfo? = null): CompletableFuture<TraktListResponse<TraktWatchedShowImpl>> {
        return RequestHandler(client).executeListRequestAsync(SyncWatchedShowsRequest(extendedInfo))
    }

    fun getWatchedHistoryAsync(
            historyItemType: TraktSyncItemType? = null,
            itemId: Int? = null,
            startAt: Instant? = null,
            endAt: Instant? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktHistoryItemImpl>> {
        return RequestHandler(client).executePagedRequestAsync(SyncWatchedHistoryRequest(
                type = historyItemType,
                itemId = itemId,
                startAt = startAt,
                endAt = endAt,
                extendedInfo = extendedInfo,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }

    fun addWatchedHistoryItemsAsync(historyPost: TraktSyncHistoryPostImpl): CompletableFuture<TraktResponse<TraktSyncHistoryPostResponseImpl>> {
        validateHistoryPost(historyPost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncWatchedHistoryAddRequest(requestBody = historyPost))
    }

    fun removeWatchedHistoryItemsAsync(historyRemovePost: TraktSyncHistoryRemovePostImpl): CompletableFuture<TraktResponse<TraktSyncHistoryRemovePostResponseImpl>> {
        validateHistoryPost(historyRemovePost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncWatchedHistoryRemoveRequest(requestBody = historyRemovePost))
    }

    fun getRatingsAsync(
            ratingsItemType: TraktRatingsItemType? = null,
            ratingsFilter: List<Int>? = null,
            extendedInfo: TraktExtendedInfo? = null
    ): CompletableFuture<TraktListResponse<TraktRatingsItemImpl>> {
        return RequestHandler(client).executeListRequestAsync(SyncRatingsRequest(
                type = ratingsItemType,
                ratingFilter = ratingsFilter,
                extendedInfo = extendedInfo
        ))
    }

    fun addRatingsAsync(ratingsPost: TraktSyncRatingsPostImpl): CompletableFuture<TraktResponse<TraktSyncRatingsPostResponseImpl>> {
        validateRatingsPost(ratingsPost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncRatingsAddRequest(requestBody = ratingsPost))
    }

    fun removeRatingsAsync(ratingsRemovePost: TraktSyncRatingsPostImpl): CompletableFuture<TraktResponse<TraktSyncRatingsRemovePostResponseImpl>> {
        validateRatingsPost(ratingsRemovePost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncRatingsRemoveRequest(requestBody = ratingsRemovePost))
    }

    fun getWatchlistAsync(
            watchlistItemType: TraktSyncItemType? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null
    ): CompletableFuture<TraktPagedResponse<TraktWatchlistItemImpl>> {
        return RequestHandler(client).executePagedRequestAsync(SyncWatchlistRequest(
                type = watchlistItemType,
                extendedInfo = extendedInfo,
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ))
    }

    fun addWatchlistItemsAsync(watchlistPost: TraktSyncWatchlistPostImpl): CompletableFuture<TraktResponse<TraktSyncWatchlistPostResponseImpl>> {
        validateWatchlistPost(watchlistPost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncWatchlistAddRequest(requestBody = watchlistPost))
    }

    fun removeWatchlistItemsAsync(watchlistRemovePost: TraktSyncWatchlistPostImpl): CompletableFuture<TraktResponse<TraktSyncWatchlistRemovePostResponseImpl>> {
        validateWatchlistPost(watchlistRemovePost)
        return RequestHandler(client).executeSingleItemRequestAsync(SyncWatchlistRemoveRequest(requestBody = watchlistRemovePost))
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
