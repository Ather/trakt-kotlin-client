package media.thehoard.thirdparty.api.trakt.requests.seasons

import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
import media.thehoard.thirdparty.api.trakt.extensions.isValidStringId
import media.thehoard.thirdparty.api.trakt.extensions.isValidTwoCharCode
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktComment
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktRating
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktStatistics
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsPagination
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.util.*
import kotlin.reflect.KClass

internal sealed class ASeasonRequest<TResponseContentType>(
        override val uriTemplate: String,
        override var id: String,
        internal var seasonNumber: Int,
        responseContentClass: KClass<*>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), IHasId {
    override val requestObjectType: RequestObjectType = RequestObjectType.Seasons

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id, "season" to seasonNumber.toString())

    override fun validate(variableName: String) = id.validate("show id", ::isValidStringId)
}

internal class SeasonCommentsRequest(
        override var id: String,
        seasonNumber: Int,
        internal var sortOrder: TraktCommentSortOrder? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : ASeasonRequest<TraktComment>(
        "shows/{id}/seasons/{season}/comments{/sort_order}{?page,limit}",
        id,
        seasonNumber,
        TraktComment::class
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
) : ASeasonRequest<TraktList>(
        "shows/{id}/seasons/{season}/lists{/type}{/sort_order}{?page,limit}",
        id,
        seasonNumber,
        TraktList::class
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
) : ASeasonRequest<TraktRating>(
        "shows/{id}/seasons/{season}/ratings",
        id,
        seasonNumber,
        TraktRating::class
)

internal class SeasonsAllRequest(
        override var id: String,
        internal var translationLanguageCode: String? = null,
        override var extendedInfo: TraktExtendedInfo? = null
) : AGetRequestHasResponse<TraktSeason>(TraktSeason::class), IHasId, ISupportsExtendedInfo {

    override val requestObjectType: RequestObjectType = RequestObjectType.Shows

    override val uriTemplate: String = "shows/{id}/seasons{?extended,translations}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id).apply {
            if (!translationLanguageCode.isNullOrBlank())
                this["translations"] = translationLanguageCode!!
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }

    override fun validate(variableName: String) {
        id.validate("show id", ::isValidStringId)
        if (translationLanguageCode != "all") translationLanguageCode.validate("translation language code has wrong length", ::isValidTwoCharCode)
    }
}

internal class SeasonSingleRequest(
        override var id: String,
        seasonNumber: Int,
        internal var translationLanguageCode: String? = null,
        override var extendedInfo: TraktExtendedInfo? = null
) : ASeasonRequest<TraktEpisode>(
        "shows/{id}/seasons/{season}{?extended,translations}",
        id,
        seasonNumber,
        TraktEpisode::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id).apply {
            if (!translationLanguageCode.isNullOrBlank())
                this["translations"] = translationLanguageCode!!
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        if (translationLanguageCode != "all") translationLanguageCode.validate("translation language code has wrong length", ::isValidTwoCharCode)
    }
}

internal class SeasonStatisticsRequest(
        override var id: String,
        seasonNumber: Int
) : ASeasonRequest<TraktStatistics>(
        "shows/{id}/seasons/{season}/stats",
        id,
        seasonNumber,
        TraktStatistics::class
)

internal class SeasonWatchingUsersRequest(
        override var id: String,
        seasonNumber: Int,
        override var extendedInfo: TraktExtendedInfo? = null
) : ASeasonRequest<TraktUser>(
        "shows/{id}/seasons/{season}/watching{?extended}",
        id,
        seasonNumber,
        TraktUser::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}