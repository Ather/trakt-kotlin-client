package media.thehoard.thirdparty.api.trakt.requests.syncs

import media.thehoard.thirdparty.api.trakt.enums.TraktRatingsItemType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncItemType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType
import media.thehoard.thirdparty.api.trakt.extensions.isValidStringId
import media.thehoard.thirdparty.api.trakt.extensions.toTraktLongDateTimeString
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionMovie
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShow
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.history.TraktHistoryItem
import media.thehoard.thirdparty.api.trakt.objects.get.ratings.TraktRatingsItem
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncLastActivities
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.playback.TraktSyncPlaybackProgressItem
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedMovie
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShow
import media.thehoard.thirdparty.api.trakt.objects.get.watchlist.TraktWatchlistItem
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPost
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.responses.TraktSyncCollectionPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.responses.TraktSyncCollectionRemovePostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPost
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryRemovePost
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryRemovePostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPost
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsRemovePostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPost
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.TraktSyncWatchlistPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.TraktSyncWatchlistRemovePostResponse
import media.thehoard.thirdparty.api.trakt.requests.base.*
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsPagination
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.time.ZonedDateTime
import java.util.*
import kotlin.reflect.KClass

internal sealed class ASyncGetRequest<TResponseContentType>(
        override val uriTemplate: String,
        responseContentClass: KClass<*>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass) {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf()

    override fun validate(variableName: String) {}
}

internal sealed class ASyncPostRequest<TResponseContentType, TRequestBodyType : IRequestBody>(
        override val uriTemplate: String,
        responseContentClass: KClass<*>
) : APostRequestHasResponse<TResponseContentType, TRequestBodyType>(responseContentClass) {
    abstract override var requestBody: TRequestBodyType?

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf()
}

internal class SyncCollectionAddRequest(
        override var requestBody: TraktSyncCollectionPost?
) : ASyncPostRequest<TraktSyncCollectionPostResponse, TraktSyncCollectionPost>(
        "sync/collection",
        TraktSyncCollectionPostResponse::class
)

internal class SyncCollectionMoviesRequest(
        override var extendedInfo: TraktExtendedInfo?
) : ASyncGetRequest<TraktCollectionMovie>(
        "sync/collection/movies{?extended}",
        TraktCollectionMovie::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class SyncCollectionRemoveRequest(
        override var requestBody: TraktSyncCollectionPost?
) : ASyncPostRequest<TraktSyncCollectionRemovePostResponse, TraktSyncCollectionPost>(
        "sync/collection/remove",
        TraktSyncCollectionRemovePostResponse::class
)

internal class SyncCollectionShowsRequest(
        override var extendedInfo: TraktExtendedInfo?
) : ASyncGetRequest<TraktCollectionShow>(
        "sync/collection/shows{?extended}",
        TraktCollectionShowEpisode::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class SyncLastActivitiesRequest : ASyncGetRequest<TraktSyncLastActivities>(
        "sync/last_activities",
        TraktSyncLastActivities::class
)

internal class SyncPlaybackDeleteRequest(
        override var id: String
) : ADeleteRequest(), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Unspecified

    override val uriTemplate: String = "sync/playback/{id}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate(variableName: String) = id.validate("object id", ::isValidStringId)
}

internal class SyncPlaybackProgressRequest(
        internal var type: TraktSyncType?,
        internal var limit: Int?
) : ASyncGetRequest<TraktSyncPlaybackProgressItem>(
        "sync/playback{/type}{?limit}",
        TraktSyncPlaybackProgressItem::class
) {

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (type != null && type != TraktSyncType.UNSPECIFIED)
                this["type"] = type!!.uriName

            if (limit != null)
                this["limit"] = limit!!.toString()
        }
}

internal class SyncRatingsAddRequest(
        override var requestBody: TraktSyncRatingsPost?
) : ASyncPostRequest<TraktSyncRatingsPostResponse, TraktSyncRatingsPost>(
        "sync/ratings",
        TraktSyncRatingsPostResponse::class
)

internal class SyncRatingsRemoveRequest(
        override var requestBody: TraktSyncRatingsPost?
) : ASyncPostRequest<TraktSyncRatingsRemovePostResponse, TraktSyncRatingsPost>(
        "sync/ratings/remove",
        TraktSyncRatingsRemovePostResponse::class
)

internal class SyncRatingsRequest(
        internal var type: TraktRatingsItemType?,
        internal var ratingFilter: List<Int>?,
        override var extendedInfo: TraktExtendedInfo?
) : ASyncGetRequest<TraktRatingsItem>(
        "sync/ratings{/type}{/rating}{?extended}",
        TraktRatingsItem::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            val isTypeSetAndValid = type != null && type != TraktRatingsItemType.UNSPECIFIED

            if (isTypeSetAndValid)
                this["type"] = type!!.uriName
            if (ratingFilter != null && isTypeSetAndValid &&
                    ratingFilter!!.size in 1..10 && ratingFilter!!.min()!! >= 1 && ratingFilter!!.max()!! <= 10)
                this["rating"] = ratingFilter!!.joinToString(",")

            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class SyncWatchedHistoryAddRequest(
        override var requestBody: TraktSyncHistoryPost?
) : ASyncPostRequest<TraktSyncHistoryPostResponse, TraktSyncHistoryPost>(
        "sync/history",
        TraktSyncHistoryPostResponse::class
)

internal class SyncWatchedHistoryRemoveRequest(
        override var requestBody: TraktSyncHistoryRemovePost?
) : ASyncPostRequest<TraktSyncHistoryRemovePostResponse, TraktSyncHistoryRemovePost>(
        "sync/history/remove",
        TraktSyncHistoryRemovePostResponse::class
)

internal class SyncWatchedHistoryRequest(
        internal var type: TraktSyncItemType?,
        internal var itemId: Int?,
        internal var startAt: ZonedDateTime?,
        internal var endAt: ZonedDateTime?,
        override var extendedInfo: TraktExtendedInfo?,
        override var page: Int?,
        override var limit: Int?
) : ASyncGetRequest<TraktHistoryItem>(
        "sync/history{/type}{/item_id}{?start_at,end_at,extended,page,limit}",
        TraktHistoryItem::class
), ISupportsExtendedInfo, ISupportsPagination {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            val isTypeSetAndValid = type != null && type != TraktSyncItemType.UNSPECIFIED

            if (isTypeSetAndValid)
                this["type"] = type!!.uriName
            if (isTypeSetAndValid && itemId != null && itemId!! > 0)
                this["item_id"] = itemId!!.toString()
            if (startAt != null)
                this["start_at"] = startAt!!.toTraktLongDateTimeString()
            if (endAt != null)
                this["end_at"] = endAt!!.toTraktLongDateTimeString()
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
            if (page != null)
                this["page"] = page!!.toString()
            if (limit != null)
                this["limit"] = limit!!.toString()
        }
}

internal class SyncWatchedMoviesRequest(
        override var extendedInfo: TraktExtendedInfo?
) : ASyncGetRequest<TraktWatchedMovie>(
        "sync/watched/movies{?extended}",
        TraktWatchedMovie::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class SyncWatchedShowsRequest(
        override var extendedInfo: TraktExtendedInfo?
) : ASyncGetRequest<TraktWatchedShow>(
        "sync/watched/shows{?extended}",
        TraktWatchedShow::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class SyncWatchlistAddRequest(
        override var requestBody: TraktSyncWatchlistPost?
) : ASyncPostRequest<TraktSyncWatchlistPostResponse, TraktSyncWatchlistPost>(
        "sync/watchlist",
        TraktSyncWatchlistPostResponse::class
)

internal class SyncWatchlistRemoveRequest(
        override var requestBody: TraktSyncWatchlistPost?
) : ASyncPostRequest<TraktSyncWatchlistRemovePostResponse, TraktSyncWatchlistPost>(
        "sync/watchlist/remove",
        TraktSyncWatchlistRemovePostResponse::class
)

internal class SyncWatchlistRequest(
        internal var type: TraktSyncItemType?,
        override var extendedInfo: TraktExtendedInfo?,
        override var page: Int?,
        override var limit: Int?
) : ASyncGetRequest<TraktWatchlistItem>(
        "sync/watchlist{/type}{?extended,page,limit}",
        TraktWatchlistItem::class
), ISupportsExtendedInfo, ISupportsPagination {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            val isTypeSetAndValid = type != null && type != TraktSyncItemType.UNSPECIFIED

            if (isTypeSetAndValid)
                this["type"] = type!!.uriName

            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()

            if (page != null)
                this["page"] = page!!.toString()

            if (limit != null)
                this["limit"] = limit!!.toString()
        }
}
