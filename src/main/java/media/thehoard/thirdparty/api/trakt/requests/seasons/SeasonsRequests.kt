package media.thehoard.thirdparty.api.trakt.requests.seasons

import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
import media.thehoard.thirdparty.api.trakt.extensions.containsSpace
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktRatingImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktStatisticsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeExtendedFullImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserExtendedFullImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsPagination
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.util.*

internal sealed class ASeasonRequest<TResponseContentType>(
        override val uriTemplate: String,
        override var id: String,
        internal var seasonNumber: Int
) : AGetRequestHasResponse<TResponseContentType>(), IHasId {
    override val requestObjectType: RequestObjectType = RequestObjectType.Seasons

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id, "season" to seasonNumber.toString())

    override fun validate() {
        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("show id not valid")
    }
}

internal class SeasonCommentsRequest(
        override var id: String,
        seasonNumber: Int,
        internal var sortOrder: TraktCommentSortOrder? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : ASeasonRequest<TraktCommentImpl>(
        "shows/{id}/seasons/{season}/comments{/sort_order}{?page,limit}",
        id,
        seasonNumber
), ISupportsPagination {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (sortOrder != null && sortOrder != TraktCommentSortOrder.UNSPECIFIED)
                this["sort_order"] = sortOrder!!.uriName
            if (page != null)
                this["page"] = page!!.toString()
            if (limit != null)
                this["limit"] = limit!!.toString()
        }
}

internal class SeasonListsRequest(
        override var id: String,
        seasonNumber: Int,
        internal var type: TraktListType? = null,
        internal var sortOrder: TraktCommentSortOrder? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : ASeasonRequest<TraktListImpl>(
        "shows/{id}/seasons/{season}/lists{/type}{/sort_order}{?page,limit}",
        id,
        seasonNumber
), ISupportsPagination {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            val isTypeSetAndValid = type != null && type != TraktListType.UNSPECIFIED

            if (isTypeSetAndValid)
                this["type"] = type!!.uriName
            if (isTypeSetAndValid && sortOrder != null && sortOrder != TraktCommentSortOrder.UNSPECIFIED)
                this["sort_order"] = sortOrder!!.uriName
            if (page != null)
                this["page"] = page!!.toString()
            if (limit != null)
                this["limit"] = limit!!.toString()
        }
}

internal class SeasonRatingsRequest(
        override var id: String,
        seasonNumber: Int
) : ASeasonRequest<TraktRatingImpl>(
        "shows/{id}/seasons/{season}/ratings",
        id,
        seasonNumber
)

internal class SeasonsAllRequest(
        override var id: String,
        internal var translationLanguageCode: String? = null,
        override var extendedInfo: TraktExtendedInfo? = null
) : AGetRequestHasResponse<TraktSeasonImpl>(), IHasId, ISupportsExtendedInfo {

    override val requestObjectType: RequestObjectType = RequestObjectType.Shows

    override val uriTemplate: String = "shows/{id}/seasons{?extended,translations}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id).apply {
            if (!translationLanguageCode.isNullOrBlank())
                this["translations"] = translationLanguageCode!!
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }

    override fun validate() {
        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("show id not valid")
        if (translationLanguageCode != null && translationLanguageCode!! != "all" && translationLanguageCode!!.length != 2)
            throw IllegalArgumentException("translation language code has wrong length")
    }
}

internal class SeasonSingleRequest(
        override var id: String,
        seasonNumber: Int,
        internal var translationLanguageCode: String? = null,
        override var extendedInfo: TraktExtendedInfo? = null
): ASeasonRequest<TraktEpisodeExtendedFullImpl>(
        "shows/{id}/seasons/{season}{?extended,translations}",
        id,
        seasonNumber
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id).apply {
            if (!translationLanguageCode.isNullOrBlank())
                this["translations"] = translationLanguageCode!!
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }

    override fun validate() {
        super.validate()
        if (translationLanguageCode != null && translationLanguageCode!! != "all" && translationLanguageCode!!.length != 2)
            throw IllegalArgumentException("translation language code has wrong length")
    }
}

internal class SeasonStatisticsRequest(
        override var id: String,
        seasonNumber: Int
) : ASeasonRequest<TraktStatisticsImpl>(
        "shows/{id}/seasons/{season}/stats",
        id,
        seasonNumber
)

internal class SeasonWatchingUsersRequest(
        override var id: String,
        seasonNumber: Int,
        override var extendedInfo: TraktExtendedInfo? = null
): ASeasonRequest<TraktUserExtendedFullImpl>(
        "shows/{id}/seasons/{season}/watching{?extended}",
        id,
        seasonNumber
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}