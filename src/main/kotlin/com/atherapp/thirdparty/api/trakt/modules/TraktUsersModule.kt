package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.enums.*
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktComment
import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionMovie
import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionShow
import com.atherapp.thirdparty.api.trakt.objects.get.history.TraktHistoryItem
import com.atherapp.thirdparty.api.trakt.objects.get.ratings.TraktRatingsItem
import com.atherapp.thirdparty.api.trakt.objects.get.users.*
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktListItem
import com.atherapp.thirdparty.api.trakt.objects.get.users.statistics.TraktUserStatistics
import com.atherapp.thirdparty.api.trakt.objects.get.watched.TraktWatchedMovie
import com.atherapp.thirdparty.api.trakt.objects.get.watched.TraktWatchedShow
import com.atherapp.thirdparty.api.trakt.objects.get.watchlist.TraktWatchlistItem
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPost
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsRemovePostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.users.implementations.TraktUserCustomListPostImpl
import com.atherapp.thirdparty.api.trakt.objects.post.users.responses.TraktUserFollowUserPostResponse
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import com.atherapp.thirdparty.api.trakt.requests.users.*
import com.atherapp.thirdparty.api.trakt.responses.TraktListResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktPagedResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import java.time.ZonedDateTime
import java.util.concurrent.CompletableFuture

class TraktUsersModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getSettingsAsync(requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktResponse<TraktUserSettings>> {
        return RequestHandler(client).executeSingleItemRequestAsync(UserSettingsRequest(), requestAuthorization)
    }

    fun getFollowRequestsAsync(
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktUserFollowRequest>> {
        return RequestHandler(client).executeListRequestAsync(UserFollowRequestsRequest(extendedInfo), requestAuthorization)
    }

    fun getHiddenItemsAsync(
            hiddenItemsSection: TraktHiddenItemsSection,
            hiddenItemType: TraktHiddenItemType? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktUserHiddenItem>> {
        return RequestHandler(client).executePagedRequestAsync(UserHiddenItemsRequest(hiddenItemsSection, hiddenItemType, extendedInfo, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getLikesAsync(
            usernameOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktUser>> {
        return RequestHandler(client).executeSingleItemRequestAsync(UserProfileRequest(usernameOrSlug, extendedInfo), requestAuthorization)
    }

    fun getCollectionMoviesAsync(
            usernameOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktCollectionMovie>> {
        return RequestHandler(client).executeListRequestAsync(UserCollectionMoviesRequest(usernameOrSlug, extendedInfo), requestAuthorization)
    }

    fun getCollectionShowsAsync(
            usernameOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktCollectionShow>> {
        return RequestHandler(client).executeListRequestAsync(UserCollectionShowsRequest(usernameOrSlug, extendedInfo), requestAuthorization)
    }

    fun getCommentsAsync(
            usernameOrSlug: String,
            commentType: TraktCommentType? = null,
            objectType: TraktObjectType? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktUserComment>> {
        return RequestHandler(client).executePagedRequestAsync(UserCommentsRequest(
                usernameOrSlug, commentType, objectType, extendedInfo, pagedParameters?.page, pagedParameters?.limit
        ), requestAuthorization)
    }

    fun getCustomListsAsync(
            usernameOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktList>> {
        return RequestHandler(client).executeListRequestAsync(UserCustomListsRequest(usernameOrSlug), requestAuthorization)
    }

    fun getCustomSingleListAsync(
            usernameOrSlug: String,
            listIdOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktList>> {
        return RequestHandler(client).executeListRequestAsync(UserCustomSingleListRequest(usernameOrSlug, listIdOrSlug), requestAuthorization)
    }

    fun getMultipleCustomListsAsync(
            userListsQueryParams: TraktMultipleUserListsQueryParams,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<List<TraktListResponse<TraktList>>> {
        if (userListsQueryParams.isEmpty())
            return CompletableFuture.completedFuture(listOf())

        var i = 0
        val tasks = Array(userListsQueryParams.size, {
            val queryParam = userListsQueryParams[i++]
            return@Array getCustomSingleListAsync(queryParam.username, queryParam.listId, requestAuthorization)
        })

        return CompletableFuture.supplyAsync {
            i = 0
            List(tasks.size, { tasks[i++].get() })
        }
    }

    fun getCustomListItemsAsync(
            usernameOrSlug: String,
            listIdOrSlug: String,
            listItemType: TraktListItemType? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktListItem>> {
        return RequestHandler(client).executePagedRequestAsync(UserCustomListItemsRequest(
                usernameOrSlug, listIdOrSlug, listItemType, extendedInfo, pagedParameters?.page, pagedParameters?.limit
        ), requestAuthorization)
    }

    fun createCustomListAsync(
            usernameOrSlug: String,
            listName: String,
            listDescription: String? = null,
            privacy: TraktAccessScope? = null,
            displayNumbers: Boolean? = null,
            allowComments: Boolean? = null,
            listSortBy: TraktListSortBy? = null,
            listSortHow: TraktListSortHow? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktList>> {
        return RequestHandler(client).executeSingleItemRequestAsync(UserCustomListAddRequest(
                usernameOrSlug,
                TraktUserCustomListPostImpl(listName, listDescription, if (privacy != TraktAccessScope.UNSPECIFIED) privacy else null, displayNumbers, allowComments, listSortBy, listSortHow)
        ), requestAuthorization)
    }

    fun updateCustomListAsync(
            usernameOrSlug: String,
            listIdOrSlug: String,
            listName: String,
            listDescription: String? = null,
            privacy: TraktAccessScope? = null,
            displayNumbers: Boolean? = null,
            allowComments: Boolean? = null,
            listSortBy: TraktListSortBy? = null,
            listSortHow: TraktListSortHow? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktList>> {
        return RequestHandler(client).executeSingleItemRequestAsync(UserCustomListUpdateRequest(
                usernameOrSlug, listIdOrSlug,
                TraktUserCustomListPostImpl(listName, listDescription, if (privacy != TraktAccessScope.UNSPECIFIED) privacy else null, displayNumbers, allowComments, listSortBy, listSortHow)
        ), requestAuthorization)
    }

    fun deleteCustomListAsync(
            usernameOrSlug: String,
            listIdOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktNoContentResponse> {
        return RequestHandler(client).executeNoContentRequestAsync(UserCustomListDeleteRequest(usernameOrSlug, listIdOrSlug), requestAuthorization)
    }

    fun addCustomListItemsAsync(
            usernameOrSlug: String,
            listIdOrSlug: String,
            listItemsPost: TraktUserCustomListItemsPost,
            listItemType: TraktListItemType? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktUserCustomListItemsPostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(UserCustomListItemsAddRequest(usernameOrSlug, listIdOrSlug, listItemType, listItemsPost), requestAuthorization)
    }

    fun removeCustomListItemsAsync(
            usernameOrSlug: String,
            listIdOrSlug: String,
            listItemsRemovePost: TraktUserCustomListItemsPost,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktUserCustomListItemsRemovePostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(UserCustomListItemsRemoveRequest(usernameOrSlug, listIdOrSlug, listItemsRemovePost), requestAuthorization)
    }

    fun getListCommentsAsync(
            usernameOrSlug: String,
            listIdOrSlug: String,
            commentSortOrder: TraktCommentSortOrder? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktComment>> {
        return RequestHandler(client).executePagedRequestAsync(UserListCommentsRequest(
                usernameOrSlug, listIdOrSlug, commentSortOrder, pagedParameters?.page, pagedParameters?.limit
        ), requestAuthorization)
    }

    fun likeListAsync(
            usernameOrSlug: String,
            listIdOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktNoContentResponse> {
        return RequestHandler(client).executeNoContentRequestAsync(UserListLikeRequest(usernameOrSlug, listIdOrSlug), requestAuthorization)
    }

    fun unlikeListAsync(
            usernameOrSlug: String,
            listIdOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktNoContentResponse> {
        return RequestHandler(client).executeNoContentRequestAsync(UserListUnlikeRequest(usernameOrSlug, listIdOrSlug), requestAuthorization)
    }

    fun getFollowersAsync(
            usernameOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktUserFollower>> {
        return RequestHandler(client).executeListRequestAsync(UserFollowersRequest(usernameOrSlug, extendedInfo), requestAuthorization)
    }

    fun getFollowingAsync(
            usernameOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktUserFollower>> {
        return RequestHandler(client).executeListRequestAsync(UserFollowingRequest(usernameOrSlug, extendedInfo), requestAuthorization)
    }

    fun getFriendsAsync(
            usernameOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktUserFollower>> {
        return RequestHandler(client).executeListRequestAsync(UserFriendsRequest(usernameOrSlug, extendedInfo), requestAuthorization)
    }

    fun followUserAsync(
            usernameOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktUserFollowUserPostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(UserFollowUserRequest(usernameOrSlug), requestAuthorization)
    }

    fun unfollowUserAsync(
            usernameOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktNoContentResponse> {
        return RequestHandler(client).executeNoContentRequestAsync(UserUnfollowUserRequest(usernameOrSlug), requestAuthorization)
    }

    fun approveFollowRequestAsync(
            followerRequestId: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktUserFollower>> {
        return RequestHandler(client).executeSingleItemRequestAsync(UserApproveFollowerRequest(followerRequestId.toString()), requestAuthorization)
    }

    fun denyFollowRequestAsync(
            followerRequestId: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktNoContentResponse> {
        return RequestHandler(client).executeNoContentRequestAsync(UserDenyFollowerRequest(followerRequestId.toString()), requestAuthorization)
    }

    fun getWatchedHistoryAsync(
            usernameOrSlug: String,
            historyItemType: TraktSyncItemType? = null,
            itemId: Int? = null,
            startAt: ZonedDateTime? = null,
            endAt: ZonedDateTime? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktHistoryItem>> {
        return RequestHandler(client).executePagedRequestAsync(UserWatchedHistoryRequest(
                usernameOrSlug, historyItemType, itemId, startAt, endAt, extendedInfo, pagedParameters?.page, pagedParameters?.limit
        ), requestAuthorization)
    }

    fun getRatingsAsync(
            usernameOrSlug: String,
            ratingsItemType: TraktRatingsItemType? = null,
            ratingsFilter: Array<Int>? = null,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktRatingsItem>> {
        return RequestHandler(client).executeListRequestAsync(UserRatingsRequest(usernameOrSlug, ratingsItemType, ratingsFilter, extendedInfo), requestAuthorization)
    }

    fun getWatchlistAsync(
            usernameOrSlug: String,
            watchlistItemType: TraktSyncItemType? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktWatchlistItem>> {
        return RequestHandler(client).executeListRequestAsync(UserWatchlistRequest(usernameOrSlug, watchlistItemType, extendedInfo, pagedParameters?.page, pagedParameters?.limit), requestAuthorization)
    }

    fun getWatchingAsync(
            usernameOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktUserWatchingItem>> {
        return RequestHandler(client).executeSingleItemRequestAsync(UserWatchingRequest(usernameOrSlug, extendedInfo), requestAuthorization)
    }

    fun getWatchedMoviesAsync(
            usernameOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktWatchedMovie>> {
        return RequestHandler(client).executeListRequestAsync(UserWatchedMoviesRequest(usernameOrSlug, extendedInfo), requestAuthorization)
    }

    fun getWatchedShowsAsync(
            usernameOrSlug: String,
            extendedInfo: TraktExtendedInfo? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktListResponse<TraktWatchedShow>> {
        return RequestHandler(client).executeListRequestAsync(UserWatchedShowsRequest(usernameOrSlug, extendedInfo), requestAuthorization)
    }

    fun getStatisticsAsync(
            usernameOrSlug: String,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktUserStatistics>> {
        return RequestHandler(client).executeSingleItemRequestAsync(UserStatisticsRequest(usernameOrSlug), requestAuthorization)
    }
}
