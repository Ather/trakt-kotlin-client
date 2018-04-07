package media.thehoard.thirdparty.api.trakt.requests.users

import com.google.gson.reflect.TypeToken
import media.thehoard.thirdparty.api.trakt.enums.*
import media.thehoard.thirdparty.api.trakt.extensions.containsSpace
import media.thehoard.thirdparty.api.trakt.extensions.toTraktLongDateTimeString
import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.history.implementations.TraktHistoryItemImpl
import media.thehoard.thirdparty.api.trakt.objects.get.ratings.implementations.TraktRatingsItemImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListItemImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations.TraktUserStatisticsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watchlist.implementations.TraktWatchlistItemImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations.TraktUserCustomListItemsPostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsRemovePostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.implementations.TraktUserCustomListPostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.responses.implementations.TraktUserFollowUserPostResponseImpl
import media.thehoard.thirdparty.api.trakt.requests.base.*
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsPagination
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.time.ZonedDateTime
import java.util.*
import kotlin.reflect.KClass

internal sealed class AUsersDeleteByIdRequest(
        override val uriTemplate: String,
        override var id: String
) : ADeleteRequest(), IHasId {

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate() {
        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("id not valid")
    }
}

internal sealed class AUsersGetRequest<TResponseContentType>(
        override val uriTemplate: String,
        override var extendedInfo: TraktExtendedInfo? = null,
        responseContentClass: KClass<*>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), ISupportsExtendedInfo {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Optional

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf<String, String>().apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }

    override fun validate() {}
}

internal sealed class AUsersPagedGetRequest<TResponseContentType>(
        uriTemplate: String,
        extendedInfo: TraktExtendedInfo? = null,
        override var page: Int? = null,
        override var limit: Int? = null,
        responseContentClass: KClass<*>
) : AUsersGetRequest<TResponseContentType>(
        uriTemplate,
        extendedInfo,
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
        override var id: String,
        override var requestBody: TRequestBodyType? = null,
        responseContentClass: KClass<*>
) : APostRequestHasResponse<TResponseContentType, TRequestBodyType>(responseContentClass), IHasId {

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate() {
        super.validate()

        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("id not valid")
    }
}

internal class UserApproveFollowerRequest(
        override var id: String
) : ABodylessPostRequestHasResponse<TraktUserFollowerImpl>(TraktUserFollowerImpl::class), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Unspecified

    override val uriTemplate: String = "users/requests/{id}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)


    override fun validate() {
        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("id not valid")
    }
}

internal class UserCollectionMoviesRequest(
        extendedInfo: TraktExtendedInfo? = null,
        internal var username: String
) : AUsersGetRequest<TraktCollectionMovieImpl>(
        "users/{username}/collection/movies{?extended}",
        extendedInfo,
        TraktCollectionMovieImpl::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

//TODO FIXME 04/06/18 Consider the implications of nested generics here.
internal class UserCollectionShowsRequest(
        extendedInfo: TraktExtendedInfo? = null,
        internal var username: String
) : AUsersGetRequest<TraktCollectionShowImpl>(
        "users/{username}/collection/shows{?extended}",
        extendedInfo,
        (object : TypeToken<TraktCollectionShowImpl>() {}.type) as KClass<*>
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserCommentsRequest(
        extendedInfo: TraktExtendedInfo? = null,
        internal var username: String,
        internal var commentType: TraktCommentType? = null,
        internal var objectType: TraktObjectType? = null
) : AUsersPagedGetRequest<TraktUserCommentImpl>(
        "users/{username}/comments{/comment_type}{/object_type}{?extended,page,limit}",
        extendedInfo,
        responseContentClass = TraktUserCommentImpl::class
) {

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username

            if (commentType != null && commentType != TraktCommentType.UNSPECIFIED)
                this["comment_type"] = commentType!!.uriName
            if (objectType != null && objectType != TraktObjectType.UNSPECIFIED)
                this["object_type"] = objectType!!.uriName
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserCustomListAddRequest(
        internal var username: String,
        override var requestBody: TraktUserCustomListPostImpl? = null
) : APostRequestHasResponse<TraktListImpl, TraktUserCustomListPostImpl>(TraktListImpl::class) {

    override val uriTemplate: String = "users/{username}/lists"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username)

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserCustomListDeleteRequest(
        id: String,
        internal var username: String
) : AUsersDeleteByIdRequest(
        "users/{username}/lists/{id}",
        id
) {

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserCustomListItemsAddRequest(
        id: String,
        internal var username: String,
        requestBody: TraktUserCustomListItemsPostImpl? = null,
        internal var type: TraktListItemType? = null
) : AUsersPostByIdRequest<TraktUserCustomListItemsPostResponseImpl, TraktUserCustomListItemsPostImpl>(
        "users/{username}/lists/{id}/items{/type}",
        id,
        requestBody,
        TraktUserCustomListItemsPostResponseImpl::class
) {

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username

            if (type != null && type != TraktListItemType.UNSPECIFIED)
                this["type"] = type!!.uriName
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserCustomListItemsRemoveRequest(
        id: String,
        internal var username: String,
        requestBody: TraktUserCustomListItemsPostImpl? = null
) : AUsersPostByIdRequest<TraktUserCustomListItemsRemovePostResponseImpl, TraktUserCustomListItemsPostImpl>(
        "users/{username}/lists/{id}/items/remove",
        id,
        requestBody,
        TraktUserCustomListItemsRemovePostResponseImpl::class
) {

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserCustomListItemsRequest(
        override var id: String,
        internal var username: String,
        internal var type: TraktListItemType? = null,
        extendedInfo: TraktExtendedInfo? = null
) : AUsersPagedGetRequest<TraktListItemImpl>(
        "users/{username}/lists/{id}/items{/type}{?extended,page,limit}",
        extendedInfo,
        responseContentClass = TraktListItemImpl::class
), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
            this["id"] = id

            if (type != null && type != TraktListItemType.UNSPECIFIED)
                this["type"] = type!!.uriName
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")

        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("list id not valid")
    }
}

internal class UserCustomListsRequest(
        internal var username: String
) : AGetRequestHasResponse<TraktListImpl>(TraktListImpl::class) {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Optional

    override val uriTemplate: String = "users/{username}/lists"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username)

    override fun validate() {
        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserCustomListUpdateRequest(
        override var id: String,
        internal var username: String,
        override var requestBody: TraktUserCustomListPostImpl? = null
) : APutRequestHasResponse<TraktListImpl, TraktUserCustomListPostImpl>(TraktListImpl::class), IHasId {

    override val uriTemplate: String = "users/{username}/lists/{id}"

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username, "id" to id)

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")

        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("list id not valid")
    }
}

internal class UserCustomSingleListRequest(
        override var id: String,
        internal var username: String
) : AGetRequestHasResponse<TraktListImpl>(TraktListImpl::class), IHasId {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Optional

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriTemplate: String = "users/{username}/lists/{id}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username, "id" to id)

    override fun validate() {
        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")

        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("list id not valid")
    }
}

internal class UserDenyFollowerRequest(
        id: String
) : AUsersDeleteByIdRequest(
        "users/requests/{id}",
        id
) {
    override val requestObjectType: RequestObjectType = RequestObjectType.Unspecified
}

internal class UserFollowersRequest(
        extendedInfo: TraktExtendedInfo? = null,
        internal var username: String
) : AUsersGetRequest<TraktUserFollowerImpl>(
        "users/{username}/followers{?extended}",
        extendedInfo,
        responseContentClass = TraktUserFollowerImpl::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserFollowingRequest(
        extendedInfo: TraktExtendedInfo? = null,
        internal var username: String
) : AUsersGetRequest<TraktUserFollowerImpl>(
        "users/{username}/following{?extended}",
        extendedInfo,
        responseContentClass = TraktUserFollowerImpl::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserFollowRequestsRequest(
        extendedInfo: TraktExtendedInfo? = null
) : AUsersGetRequest<TraktUserFollowRequestImpl>(
        "users/requests{?extended}",
        extendedInfo,
        TraktUserFollowRequestImpl::class
) {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required
}

internal class UserFollowUserRequest(
        internal var username: String
) : ABodylessPostRequestHasResponse<TraktUserFollowUserPostResponseImpl>(TraktUserFollowUserPostResponseImpl::class) {

    override val uriTemplate: String = "users/{username}/follow"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username)

    override fun validate() {
        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserFriendsRequest(
        extendedInfo: TraktExtendedInfo? = null,
        internal var username: String
) : AUsersGetRequest<TraktUserFollowerImpl>(
        "users/{username}/friends{?extended}",
        extendedInfo,
        responseContentClass = TraktUserFollowerImpl::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserHiddenItemsRequest(
        internal var section: TraktHiddenItemsSection,
        internal var type: TraktHiddenItemType? = null,
        extendedInfo: TraktExtendedInfo? = null,
        page: Int? = null,
        limit: Int? = null
) : AUsersPagedGetRequest<TraktUserHiddenItemImpl>(
        "users/hidden/{section}{?type,extended,page,limit}",
        extendedInfo,
        page,
        limit,
        TraktUserHiddenItemImpl::class
) {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["section"] = section.uriName

            if (type != null && type != TraktHiddenItemType.UNSPECIFIIED)
                this["type"] = type!!.uriName
        }

    override fun validate() {
        super.validate()

        if (section == TraktHiddenItemsSection.UNSPECIFIED)
            throw IllegalArgumentException("section type must not be unspecified")
    }
}

internal class UserLikesRequest(
        internal var type: TraktUserLikeType? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AGetRequestHasResponse<TraktUserLikeItemImpl>(TraktUserLikeItemImpl::class), ISupportsPagination {

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

    override fun validate() {}
}

internal class UserListLikeRequest(
        override var id: String,
        internal var username: String
) : ABodylessPostRequest(), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriTemplate: String = "users/{username}/lists/{id}/like"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username, "id" to id)

    override fun validate() {
        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")

        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("list id not valid")
    }
}

internal class UserListUnlikeRequest(
        id: String,
        internal var username: String
) : AUsersDeleteByIdRequest(
        "users/{username}/lists/{id}/like",
        id
), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserProfileRequest(
        extendedInfo: TraktExtendedInfo? = null,
        internal var username: String
) : AUsersGetRequest<TraktUserImpl>(
        "users/{username}/friends{?extended}",
        extendedInfo,
        responseContentClass = TraktUserImpl::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserRatingsRequest(
        internal var username: String,
        internal var type: TraktRatingsItemType? = null,
        internal var ratingFilter: List<Int>? = null,
        extendedInfo: TraktExtendedInfo? = null
) : AUsersGetRequest<TraktRatingsItemImpl>(
        "users/{username}/ratings{/type}{/rating}{?extended}",
        extendedInfo,
        TraktRatingsItemImpl::class
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

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserSettingsRequest : AGetRequestHasResponse<TraktUserSettingsImpl>(TraktUserSettingsImpl::class) {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val uriTemplate: String = "users/settings"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf()

    override fun validate() {}
}

internal class UserStatisticsRequest(
        internal var username: String
) : AGetRequestHasResponse<TraktUserStatisticsImpl>(TraktUserStatisticsImpl::class) {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Optional

    override val uriTemplate: String = "users/{username}/stats"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username)

    override fun validate() {
        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserUnfollowUserRequest(
        internal var username: String
) : ADeleteRequest() {

    override val uriTemplate: String = "users/{username}/follow"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username)

    override fun validate() {
        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserWatchedHistoryRequest(
        internal var username: String,
        override var id: String,
        internal var type: TraktSyncItemType? = null,
        internal var itemId: Int? = null,
        internal var startAt: ZonedDateTime? = null,
        internal var endAt: ZonedDateTime? = null,
        page: Int? = null,
        limit: Int? = null,
        extendedInfo: TraktExtendedInfo? = null
) : AUsersPagedGetRequest<TraktHistoryItemImpl>(
        "users/{username}/history{/type}{/item_id}{?start_at,end_at,extended,page,limit}",
        extendedInfo,
        page,
        limit,
        TraktHistoryItemImpl::class
), IHasId {

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

    override fun validate() {
        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserWatchedMoviesRequest(
        extendedInfo: TraktExtendedInfo? = null,
        internal var username: String
) : AUsersGetRequest<TraktWatchedMovieImpl>(
        "users/{username}/watched/movies{?extended}",
        extendedInfo,
        responseContentClass = TraktWatchedMovieImpl::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserWatchedShowsRequest(
        extendedInfo: TraktExtendedInfo? = null,
        internal var username: String
) : AUsersGetRequest<TraktWatchedShowImpl>(
        "users/{username}/watched/shows{?extended}",
        extendedInfo,
        responseContentClass = TraktWatchedShowImpl::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserWatchingRequest(
        extendedInfo: TraktExtendedInfo? = null,
        internal var username: String
) : AUsersGetRequest<TraktUserWatchingItemImpl>(
        "users/{username}/watching{?extended}",
        extendedInfo,
        responseContentClass = TraktUserWatchingItemImpl::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}

internal class UserWatchlistRequest(
        internal var username: String,
        extendedInfo: TraktExtendedInfo? = null,
        var type: TraktSyncItemType? = null,
        page: Int? = null,
        limit: Int? = null
) : AUsersPagedGetRequest<TraktWatchlistItemImpl>(
        "users/{username}/watchlist{/type}{?extended,page,limit}",
        extendedInfo,
        page,
        limit,
        TraktWatchlistItemImpl::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["username"] = username

            if (type != null && type != TraktSyncItemType.UNSPECIFIED)
                this["type"] = type!!.uriName
        }

    override fun validate() {
        super.validate()

        if (username.isBlank() || username.containsSpace())
            throw IllegalArgumentException("username not valid")
    }
}