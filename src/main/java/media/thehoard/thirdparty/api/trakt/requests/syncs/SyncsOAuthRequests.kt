package media.thehoard.thirdparty.api.trakt.requests.syncs

import media.thehoard.thirdparty.api.trakt.enums.TraktRatingsItemType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncItemType
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType
import media.thehoard.thirdparty.api.trakt.extensions.containsSpace
import media.thehoard.thirdparty.api.trakt.extensions.toTraktLongDateTimeString
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
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations.TraktSyncCollectionPostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.responses.implementations.TraktSyncCollectionPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.responses.implementations.TraktSyncCollectionRemovePostResponseImpl
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
import media.thehoard.thirdparty.api.trakt.requests.base.*
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsPagination
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.time.Instant
import java.util.*

internal sealed class ASyncGetRequest<TResponseContentType>(
        override val uriTemplate: String
) : AGetRequestHasResponse<TResponseContentType>() {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf()

    override fun validate() {}
}

internal sealed class ASyncPostRequest<TResponseContentType, TRequestBodyType : IRequestBody>(
        override val uriTemplate: String,
        override var requestBody: TRequestBodyType? = null
) : APostRequestHasResponse<TResponseContentType, TRequestBodyType>() {
    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf()
}

internal class SyncCollectionAddRequest(
        override var requestBody: TraktSyncCollectionPostImpl? = null
) : ASyncPostRequest<TraktSyncCollectionPostResponseImpl, TraktSyncCollectionPostImpl>(
        "sync/collection",
        requestBody
)

internal class SyncCollectionMoviesRequest(
        override var extendedInfo: TraktExtendedInfo? = null
) : ASyncGetRequest<TraktCollectionMovieExtendedMetadataImpl>("sync/collection/movies{?extended}"), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class SyncCollectionRemoveRequest(
        override var requestBody: TraktSyncCollectionPostImpl? = null
) : ASyncPostRequest<TraktSyncCollectionRemovePostResponseImpl, TraktSyncCollectionPostImpl>(
        "sync/collection/remove",
        requestBody
)

internal class SyncCollectionShowsRequest(
        override var extendedInfo: TraktExtendedInfo? = null
) : ASyncGetRequest<TraktCollectionShowImpl<TraktCollectionShowEpisodeExtendedMetadataImpl>>("sync/collection/shows{?extended}"), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class SyncLastActivitiesRequest : ASyncGetRequest<TraktSyncLastActivitiesImpl>("sync/last_activities")

internal class SyncPlaybackDeleteRequest(
        override var id: String
) : ADeleteRequest(), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Unspecified

    override val uriTemplate: String = "sync/playback/{id}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate() {
        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("object id is not valid")
    }
}

internal class SyncPlaybackProgressRequest(
        internal var type: TraktSyncType? = null,
        internal var limit: Int? = null
) : ASyncGetRequest<TraktSyncPlaybackProgressItemImpl>("sync/playback{/type}{?limit}") {

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (type != null && type != TraktSyncType.UNSPECIFIED)
                this["type"] = type!!.uriName

            if (limit != null)
                this["limit"] = limit!!.toString()
        }
}

internal class SyncRatingsAddRequest(
        override var requestBody: TraktSyncRatingsPostImpl? = null
) : ASyncPostRequest<TraktSyncRatingsPostResponseImpl, TraktSyncRatingsPostImpl>(
        "sync/ratings",
        requestBody
)

internal class SyncRatingsRemoveRequest(
        override var requestBody: TraktSyncRatingsPostImpl? = null
) : ASyncPostRequest<TraktSyncRatingsRemovePostResponseImpl, TraktSyncRatingsPostImpl>(
        "sync/ratings/remove",
        requestBody
)

internal class SyncRatingsRequest(
        internal var type: TraktRatingsItemType? = null,
        internal var ratingFilter: List<Int>? = null,
        override var extendedInfo: TraktExtendedInfo? = null
) : ASyncGetRequest<TraktRatingsItemImpl>("sync/ratings{/type}{/rating}{?extended}"), ISupportsExtendedInfo {
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
        override var requestBody: TraktSyncHistoryPostImpl? = null
) : ASyncPostRequest<TraktSyncHistoryPostResponseImpl, TraktSyncHistoryPostImpl>(
        "sync/history",
        requestBody
)

internal class SyncWatchedHistoryRemoveRequest(
        override var requestBody: TraktSyncHistoryRemovePostImpl? = null
) : ASyncPostRequest<TraktSyncHistoryRemovePostResponseImpl, TraktSyncHistoryRemovePostImpl>(
        "sync/history/remove",
        requestBody
)

internal class SyncWatchedHistoryRequest(
        internal var type: TraktSyncItemType? = null,
        internal var itemId: Int? = null,
        internal var startAt: Instant? = null,
        internal var endAt: Instant? = null,
        override var extendedInfo: TraktExtendedInfo? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : ASyncGetRequest<TraktHistoryItemImpl>(
        "sync/history{/type}{/item_id}{?start_at,end_at,extended,page,limit}"
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
        override var extendedInfo: TraktExtendedInfo? = null
) : ASyncGetRequest<TraktWatchedMovieImpl>("sync/watched/movies{?extended}"), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class SyncWatchedShowsRequest(
        override var extendedInfo: TraktExtendedInfo? = null
) : ASyncGetRequest<TraktWatchedShowImpl>("sync/watched/shows{?extended}"), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class SyncWatchlistAddRequest(
        override var requestBody: TraktSyncWatchlistPostImpl? = null
) : ASyncPostRequest<TraktSyncWatchlistPostResponseImpl, TraktSyncWatchlistPostImpl>(
        "sync/watchlist",
        requestBody
)

internal class SyncWatchlistRemoveRequest(
        override var requestBody: TraktSyncWatchlistPostImpl? = null
) : ASyncPostRequest<TraktSyncWatchlistRemovePostResponseImpl, TraktSyncWatchlistPostImpl>(
        "sync/watchlist/remove",
        requestBody
)

internal class SyncWatchlistRequest(
        internal var type: TraktSyncItemType? = null,
        override var extendedInfo: TraktExtendedInfo? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : ASyncGetRequest<TraktWatchlistItemImpl>("sync/watchlist{/type}{?extended,page,limit}"), ISupportsExtendedInfo, ISupportsPagination {
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
