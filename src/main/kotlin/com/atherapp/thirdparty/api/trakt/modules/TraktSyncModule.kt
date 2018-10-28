package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.enums.TraktRatingsItemType
import com.atherapp.thirdparty.api.trakt.enums.TraktSyncItemType
import com.atherapp.thirdparty.api.trakt.enums.TraktSyncType
import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionMovie
import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionShow
import com.atherapp.thirdparty.api.trakt.objects.get.history.TraktHistoryItem
import com.atherapp.thirdparty.api.trakt.objects.get.ratings.TraktRatingsItem
import com.atherapp.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncLastActivities
import com.atherapp.thirdparty.api.trakt.objects.get.syncs.playback.TraktSyncPlaybackProgressItem
import com.atherapp.thirdparty.api.trakt.objects.get.watched.TraktWatchedMovie
import com.atherapp.thirdparty.api.trakt.objects.get.watched.TraktWatchedShow
import com.atherapp.thirdparty.api.trakt.objects.get.watchlist.TraktWatchlistItem
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPost
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.responses.TraktSyncCollectionPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.responses.TraktSyncCollectionRemovePostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPost
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryRemovePost
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryRemovePostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPost
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsRemovePostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPost
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.TraktSyncWatchlistPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.TraktSyncWatchlistRemovePostResponse
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import com.atherapp.thirdparty.api.trakt.requests.syncs.*
import com.atherapp.thirdparty.api.trakt.responses.TraktListResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktPagedResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import kotlinx.coroutines.Deferred
import java.time.ZonedDateTime

class TraktSyncModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getLastActivitiesAsync(requestAuthorization: TraktAuthorization = client.authorization): Deferred<TraktResponse<TraktSyncLastActivities>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SyncLastActivitiesRequest(), requestAuthorization)
    }

    fun getPlaybackProgressAsync(
            objectType: TraktSyncType? = null,
            limit: Int? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktListResponse<TraktSyncPlaybackProgressItem>> {
        return RequestHandler(client).executeListRequestAsync(SyncPlaybackProgressRequest(objectType, limit), requestAuthorization)
    }

    fun removePlaybackItemAsync(
            playbackId: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktNoContentResponse> {
        return RequestHandler(client).executeNoContentRequestAsync(SyncPlaybackDeleteRequest(playbackId.toString()), requestAuthorization)
    }

    fun getCollectionMoviesAsync(
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktListResponse<TraktCollectionMovie>> {
        return RequestHandler(client).executeListRequestAsync(SyncCollectionMoviesRequest(extendedInfo), requestAuthorization)
    }

    fun getCollectionShowsAsync(
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktListResponse<TraktCollectionShow>> {
        return RequestHandler(client).executeListRequestAsync(SyncCollectionShowsRequest(extendedInfo), requestAuthorization)
    }

    fun addCollectionItemsAsync(
            collectionPost: TraktSyncCollectionPost,
            requestAuthorization: TraktAuthorization
    ): Deferred<TraktResponse<TraktSyncCollectionPostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SyncCollectionAddRequest(collectionPost), requestAuthorization)
    }

    fun removeCollectionItemsAsync(
            collectionRemovePost: TraktSyncCollectionPost,
            requestAuthorization: TraktAuthorization
    ): Deferred<TraktResponse<TraktSyncCollectionRemovePostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SyncCollectionRemoveRequest(collectionRemovePost), requestAuthorization)
    }

    fun getWatchedMoviesAsync(
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization
    ): Deferred<TraktListResponse<TraktWatchedMovie>> {
        return RequestHandler(client).executeListRequestAsync(SyncWatchedMoviesRequest(extendedInfo), requestAuthorization)
    }

    fun getWatchedShowsAsync(
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization
    ): Deferred<TraktListResponse<TraktWatchedShow>> {
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
    ): Deferred<TraktPagedResponse<TraktHistoryItem>> {
        return RequestHandler(client).executePagedRequestAsync(SyncWatchedHistoryRequest(
                historyItemType, itemId, startAt, endAt, extendedInfo, pagedParameters?.page, pagedParameters?.limit
        ), requestAuthorization)
    }

    fun addWatchedHistoryItemsAsync(
            historyPost: TraktSyncHistoryPost,
            requestAuthorization: TraktAuthorization
    ): Deferred<TraktResponse<TraktSyncHistoryPostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SyncWatchedHistoryAddRequest(historyPost), requestAuthorization)
    }

    fun removeWatchedHistoryItemsAsync(
            historyRemovePost: TraktSyncHistoryRemovePost,
            requestAuthorization: TraktAuthorization
    ): Deferred<TraktResponse<TraktSyncHistoryRemovePostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SyncWatchedHistoryRemoveRequest(historyRemovePost), requestAuthorization)
    }

    fun getRatingsAsync(
            ratingsItemType: TraktRatingsItemType? = null,
            ratingsFilter: List<Int>? = null,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktListResponse<TraktRatingsItem>> {
        return RequestHandler(client).executeListRequestAsync(SyncRatingsRequest(ratingsItemType, ratingsFilter, extendedInfo), requestAuthorization)
    }

    fun addRatingsAsync(
            ratingsPost: TraktSyncRatingsPost,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktSyncRatingsPostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SyncRatingsAddRequest(ratingsPost), requestAuthorization)
    }

    fun removeRatingsAsync(
            ratingsRemovePost: TraktSyncRatingsPost,
            requestAuthorization: TraktAuthorization
    ): Deferred<TraktResponse<TraktSyncRatingsRemovePostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SyncRatingsRemoveRequest(ratingsRemovePost), requestAuthorization)
    }

    fun getWatchlistAsync(
            watchlistItemType: TraktSyncItemType? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktPagedResponse<TraktWatchlistItem>> {
        return RequestHandler(client).executePagedRequestAsync(SyncWatchlistRequest(
                watchlistItemType, extendedInfo, pagedParameters?.page, pagedParameters?.limit
        ), requestAuthorization)
    }

    fun addWatchlistItemsAsync(
            watchlistPost: TraktSyncWatchlistPost,
            requestAuthorization: TraktAuthorization
    ): Deferred<TraktResponse<TraktSyncWatchlistPostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SyncWatchlistAddRequest(watchlistPost), requestAuthorization)
    }

    fun removeWatchlistItemsAsync(
            watchlistRemovePost: TraktSyncWatchlistPost,
            requestAuthorization: TraktAuthorization
    ): Deferred<TraktResponse<TraktSyncWatchlistRemovePostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(SyncWatchlistRemoveRequest(watchlistRemovePost), requestAuthorization)
    }
}
