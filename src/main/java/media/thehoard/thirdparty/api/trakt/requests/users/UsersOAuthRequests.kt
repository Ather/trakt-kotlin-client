package media.thehoard.thirdparty.api.trakt.requests.users

import com.google.gson.reflect.TypeToken
import media.thehoard.thirdparty.api.trakt.enums.*
import media.thehoard.thirdparty.api.trakt.extensions.isValidStringId
import media.thehoard.thirdparty.api.trakt.extensions.toTraktLongDateTimeString
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.extensions.validateSpecified
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionMovie
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShow
import media.thehoard.thirdparty.api.trakt.objects.get.history.TraktHistoryItem
import media.thehoard.thirdparty.api.trakt.objects.get.ratings.TraktRatingsItem
import media.thehoard.thirdparty.api.trakt.objects.get.users.*
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktListItem
import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.TraktUserStatistics
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedMovie
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShow
import media.thehoard.thirdparty.api.trakt.objects.get.watchlist.TraktWatchlistItem
import media.thehoard.thirdparty.api.trakt.objects.post.users.TraktUserCustomListPost
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPost
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsRemovePostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.users.responses.TraktUserFollowUserPostResponse
import media.thehoard.thirdparty.api.trakt.requests.base.*
import media.thehoard.thirdparty.api.trakt.requests.interfaces.*
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.time.ZonedDateTime
import java.util.*
import kotlin.reflect.KClass

internal sealed class AUsersDeleteByIdRequest(
        override val uriTemplate: String
) : ADeleteRequest(), IHasId {

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate(variableName: String) = id.validate("id", ::isValidStringId)
}

internal sealed class AUsersGetRequest<TResponseContentType>(
        override val uriTemplate: String,
        responseContentClass: KClass<*>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), ISupportsExtendedInfo {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Optional

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf<String, String>().apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }

    override fun validate(variableName: String) {}
}

internal sealed class AUsersPagedGetRequest<TResponseContentType>(
        uriTemplate: String,
        responseContentClass: KClass<*>
) : AUsersGetRequest<TResponseContentType>(
        uriTemplate,
        responseContentClass
), ISupportsPagination {

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (page != null)
                this["page"] = page!!.toString()
            if (limit != null)
                this["limit"] = limit!!.toString()
        }
}

internal sealed class AUsersPostByIdRequest<TResponseContentType, TRequestBodyType : IRequestBody>(
        override val uriTemplate: String,
        responseContentClass: KClass<*>
) : APostRequestHasResponse<TResponseContentType, TRequestBodyType>(responseContentClass), IHasId {

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate(variableName: String) {
        super.validate(variableName)
        id.validate("id", ::isValidStringId)
    }
}

internal class UserApproveFollowerRequest(
        override var id: String
) : ABodylessPostRequestHasResponse<TraktUserFollower>(TraktUserFollower::class), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Unspecified

    override val uriTemplate: String = "users/requests/{id}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)


    override fun validate(variableName: String) = id.validate("id", ::isValidStringId)
}

internal class UserCollectionMoviesRequest(
        internal var username: String,
        override var extendedInfo: TraktExtendedInfo?
) : AUsersGetRequest<TraktCollectionMovie>(
        "users/{username}/collection/movies{?extended}",
        TraktCollectionMovie::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

//TODO FIXME 04/06/18 Consider the implications of nested generics here.
internal class UserCollectionShowsRequest(
        internal var username: String,
        override var extendedInfo: TraktExtendedInfo?
) : AUsersGetRequest<TraktCollectionShow>(
        "users/{username}/collection/shows{?extended}",
        (object : TypeToken<TraktCollectionShow>() {}.type) as KClass<*>
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserCommentsRequest(
        internal var username: String,
        internal var commentType: TraktCommentType?,
        internal var objectType: TraktObjectType?,
        override var extendedInfo: TraktExtendedInfo?,
        override var page: Int?,
        override var limit: Int?
) : AUsersPagedGetRequest<TraktUserComment>(
        "users/{username}/comments{/comment_type}{/object_type}{?extended,page,limit}",
        TraktUserComment::class
) {

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username

            if (commentType != null && commentType != TraktCommentType.UNSPECIFIED)
                this["comment_type"] = commentType!!.uriName
            if (objectType != null && objectType != TraktObjectType.UNSPECIFIED)
                this["object_type"] = objectType!!.uriName
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserCustomListAddRequest(
        internal var username: String,
        override var requestBody: TraktUserCustomListPost?
) : APostRequestHasResponse<TraktList, TraktUserCustomListPost>(TraktList::class) {

    override val uriTemplate: String = "users/{username}/lists"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username)

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserCustomListDeleteRequest(
        internal var username: String,
        override var id: String
) : AUsersDeleteByIdRequest(
        "users/{username}/lists/{id}"
) {

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserCustomListItemsAddRequest(
        internal var username: String,
        override var id: String,
        internal var type: TraktListItemType?,
        override var requestBody: TraktUserCustomListItemsPost?
) : AUsersPostByIdRequest<TraktUserCustomListItemsPostResponse, TraktUserCustomListItemsPost>(
        "users/{username}/lists/{id}/items{/type}",
        TraktUserCustomListItemsPostResponse::class
) {

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username

            if (type != null && type != TraktListItemType.UNSPECIFIED)
                this["type"] = type!!.uriName
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserCustomListItemsRemoveRequest(
        internal var username: String,
        override var id: String,
        override var requestBody: TraktUserCustomListItemsPost?
) : AUsersPostByIdRequest<TraktUserCustomListItemsRemovePostResponse, TraktUserCustomListItemsPost>(
        "users/{username}/lists/{id}/items/remove",
        TraktUserCustomListItemsRemovePostResponse::class
) {

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserCustomListItemsRequest(
        internal var username: String,
        override var id: String,
        internal var type: TraktListItemType?,
        override var extendedInfo: TraktExtendedInfo?,
        override var page: Int?,
        override var limit: Int?
) : AUsersPagedGetRequest<TraktListItem>(
        "users/{username}/lists/{id}/items{/type}{?extended,page,limit}",
        TraktListItem::class
), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
            this["id"] = id

            if (type != null && type != TraktListItemType.UNSPECIFIED)
                this["type"] = type!!.uriName
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
        id.validate("list id", ::isValidStringId)
    }
}

internal class UserCustomListsRequest(
        internal var username: String
) : AGetRequestHasResponse<TraktList>(TraktList::class) {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Optional

    override val uriTemplate: String = "users/{username}/lists"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username)

    override fun validate(variableName: String) = username.validate("username", ::isValidStringId)
}

internal class UserCustomListUpdateRequest(
        override var id: String,
        internal var username: String,
        override var requestBody: TraktUserCustomListPost?
) : APutRequestHasResponse<TraktList, TraktUserCustomListPost>(TraktList::class), IHasId {

    override val uriTemplate: String = "users/{username}/lists/{id}"

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username, "id" to id)

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
        id.validate("list id", ::isValidStringId)
    }
}

internal class UserCustomSingleListRequest(
        override var id: String,
        internal var username: String
) : AGetRequestHasResponse<TraktList>(TraktList::class), IHasId {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Optional

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriTemplate: String = "users/{username}/lists/{id}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username, "id" to id)

    override fun validate(variableName: String) {
        username.validate("username", ::isValidStringId)
        id.validate("list id", ::isValidStringId)
    }
}

internal class UserDenyFollowerRequest(
        override var id: String
) : AUsersDeleteByIdRequest(
        "users/requests/{id}"
) {
    override val requestObjectType: RequestObjectType = RequestObjectType.Unspecified
}

internal class UserFollowersRequest(
        internal var username: String,
        override var extendedInfo: TraktExtendedInfo?
) : AUsersGetRequest<TraktUserFollower>(
        "users/{username}/followers{?extended}",
        TraktUserFollower::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserFollowingRequest(
        internal var username: String,
        override var extendedInfo: TraktExtendedInfo?
) : AUsersGetRequest<TraktUserFollower>(
        "users/{username}/following{?extended}",
        TraktUserFollower::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserFollowRequestsRequest(
        override var extendedInfo: TraktExtendedInfo?
) : AUsersGetRequest<TraktUserFollowRequest>(
        "users/requests{?extended}",
        TraktUserFollowRequest::class
) {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required
}

internal class UserFollowUserRequest(
        internal var username: String
) : ABodylessPostRequestHasResponse<TraktUserFollowUserPostResponse>(TraktUserFollowUserPostResponse::class) {

    override val uriTemplate: String = "users/{username}/follow"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username)

    override fun validate(variableName: String) {
        username.validate("username", ::isValidStringId)
    }
}

internal class UserFriendsRequest(
        internal var username: String,
        override var extendedInfo: TraktExtendedInfo?
) : AUsersGetRequest<TraktUserFollower>(
        "users/{username}/friends{?extended}",
        TraktUserFollower::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }
}

internal class UserHiddenItemsRequest(
        internal var section: TraktHiddenItemsSection,
        internal var type: TraktHiddenItemType?,
        override var extendedInfo: TraktExtendedInfo?,
        override var page: Int?,
        override var limit: Int?
) : AUsersPagedGetRequest<TraktUserHiddenItem>(
        "users/hidden/{section}{?type,extended,page,limit}",
        TraktUserHiddenItem::class
) {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["section"] = section.uriName

            if (type != null && type != TraktHiddenItemType.UNSPECIFIIED)
                this["type"] = type!!.uriName
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        section.validateSpecified("section type")
    }
}

internal class UserLikesRequest(
        internal var type: TraktUserLikeType? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AGetRequestHasResponse<TraktUserLikeItem>(TraktUserLikeItem::class), ISupportsPagination {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val uriTemplate: String = "users/likes{/type}{?page,limit}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf<String, String>().apply {
            if (type != null && type != TraktHiddenItemType.UNSPECIFIIED)
                this["type"] = type!!.uriName
            if (page != null)
                this["page"] = page!!.toString()
            if (limit != null)
                this["limit"] = limit!!.toString()
        }

    override fun validate(variableName: String) {}
}

internal class UserListLikeRequest(
        internal var username: String,
        override var id: String
) : ABodylessPostRequest(), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriTemplate: String = "users/{username}/lists/{id}/like"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username, "id" to id)

    override fun validate(variableName: String) {
        username.validate("username", ::isValidStringId)
        id.validate("list id", ::isValidStringId)
    }
}

internal class UserListUnlikeRequest(
        internal var username: String,
        override var id: String
) : AUsersDeleteByIdRequest(
        "users/{username}/lists/{id}/like"
), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserProfileRequest(
        internal var username: String,
        override var extendedInfo: TraktExtendedInfo?
) : AUsersGetRequest<TraktUser>(
        "users/{username}/friends{?extended}",
        TraktUser::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserRatingsRequest(
        internal var username: String,
        internal var type: TraktRatingsItemType?,
        internal var ratingFilter: Array<Int>?,
        override var extendedInfo: TraktExtendedInfo?
) : AUsersGetRequest<TraktRatingsItem>(
        "users/{username}/ratings{/type}{/rating}{?extended}",
        TraktRatingsItem::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username

            val isTypeSetAndValid = type != null && type != TraktRatingsItemType.UNSPECIFIED

            if (isTypeSetAndValid)
                this["type"] = type!!.uriName
            if (ratingFilter != null && isTypeSetAndValid &&
                    ratingFilter!!.size in 1..10 && ratingFilter!!.min()!! >= 1 && ratingFilter!!.max()!! <= 10)
                this["rating"] = ratingFilter!!.joinToString(",")

            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserSettingsRequest : AGetRequestHasResponse<TraktUserSettings>(TraktUserSettings::class) {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val uriTemplate: String = "users/settings"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf()

    override fun validate(variableName: String) {}
}

internal class UserStatisticsRequest(
        internal var username: String
) : AGetRequestHasResponse<TraktUserStatistics>(TraktUserStatistics::class) {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Optional

    override val uriTemplate: String = "users/{username}/stats"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username)

    override fun validate(variableName: String) = username.validate("username", ::isValidStringId)
}

internal class UserUnfollowUserRequest(
        internal var username: String
) : ADeleteRequest() {

    override val uriTemplate: String = "users/{username}/follow"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username)

    override fun validate(variableName: String) = username.validate("username", ::isValidStringId)
}

internal class UserWatchedHistoryRequest(
        internal var username: String,
        internal var type: TraktSyncItemType?,
        internal var itemId: Int?,
        internal var startAt: ZonedDateTime?,
        internal var endAt: ZonedDateTime?,
        override var extendedInfo: TraktExtendedInfo?,
        override var page: Int?,
        override var limit: Int?
) : AUsersPagedGetRequest<TraktHistoryItem>(
        "users/{username}/history{/type}{/item_id}{?start_at,end_at,extended,page,limit}",
        TraktHistoryItem::class
), IObjectRequest {

    override val requestObjectType: RequestObjectType = RequestObjectType.Unspecified

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username

            val isTypeSetAndValid = type != null && type != TraktSyncItemType.UNSPECIFIED

            if (isTypeSetAndValid)
                this["type"] = type!!.uriName
            if (isTypeSetAndValid && itemId != null && itemId!! > 0)
                this["item_id"] = itemId!!.toString()
            if (startAt != null)
                this["start_at"] = startAt!!.toTraktLongDateTimeString()
            if (endAt != null)
                this["end_at"] = endAt!!.toTraktLongDateTimeString()
        }

    override fun validate(variableName: String) = username.validate("username", ::isValidStringId)
}

internal class UserWatchedMoviesRequest(
        internal var username: String,
        override var extendedInfo: TraktExtendedInfo?
) : AUsersGetRequest<TraktWatchedMovie>(
        "users/{username}/watched/movies{?extended}",
        TraktWatchedMovie::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserWatchedShowsRequest(
        internal var username: String,
        override var extendedInfo: TraktExtendedInfo?
) : AUsersGetRequest<TraktWatchedShow>(
        "users/{username}/watched/shows{?extended}",
        TraktWatchedShow::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserWatchingRequest(
        internal var username: String,
        override var extendedInfo: TraktExtendedInfo?
) : AUsersGetRequest<TraktUserWatchingItem>(
        "users/{username}/watching{?extended}",
        TraktUserWatchingItem::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}

internal class UserWatchlistRequest(
        internal var username: String,
        internal var type: TraktSyncItemType?,
        override var extendedInfo: TraktExtendedInfo?,
        override var page: Int?,
        override var limit: Int?
) : AUsersPagedGetRequest<TraktWatchlistItem>(
        "users/{username}/watchlist{/type}{?extended,page,limit}",
        TraktWatchlistItem::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username

            if (type != null && type != TraktSyncItemType.UNSPECIFIED)
                this["type"] = type!!.uriName
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        username.validate("username", ::isValidStringId)
    }
}