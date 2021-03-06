package com.atherapp.thirdparty.api.trakt.requests.seasons

import com.atherapp.thirdparty.api.trakt.enums.TraktCommentSortOrder
import com.atherapp.thirdparty.api.trakt.enums.TraktListSortOrder
import com.atherapp.thirdparty.api.trakt.enums.TraktListType
import com.atherapp.thirdparty.api.trakt.extensions.isValidStringId
import com.atherapp.thirdparty.api.trakt.extensions.isValidTwoCharCode
import com.atherapp.thirdparty.api.trakt.extensions.validate
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktComment
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktRating
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktStatistics
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUser
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList
import com.atherapp.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import com.atherapp.thirdparty.api.trakt.requests.base.RequestObjectType
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IHasId
import com.atherapp.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import com.atherapp.thirdparty.api.trakt.requests.interfaces.ISupportsPagination
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.util.*
import kotlin.reflect.KClass

internal sealed class ASeasonRequest<TResponseContentType : Any>(
        override val uriTemplate: String,
        responseContentClass: KClass<TResponseContentType>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), IHasId {
    internal abstract var seasonNumber: Int

    override val requestObjectType: RequestObjectType = RequestObjectType.Seasons

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id, "season" to seasonNumber.toString())

    override fun validate(variableName: String) = id.validate("show id", ::isValidStringId)
}

internal class SeasonCommentsRequest(
        override var id: String,
        override var seasonNumber: Int,
        internal var sortOrder: TraktCommentSortOrder?,
        override var page: Int?,
        override var limit: Int?
) : ASeasonRequest<TraktComment>(
        "shows/{id}/seasons/{season}/comments{/sort_order}{?page,limit}",
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
        override var seasonNumber: Int,
        internal var type: TraktListType?,
        internal var sortOrder: TraktListSortOrder?,
        override var page: Int?,
        override var limit: Int?
) : ASeasonRequest<TraktList>(
        "shows/{id}/seasons/{season}/lists{/type}{/sort_order}{?page,limit}",
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
        override var seasonNumber: Int
) : ASeasonRequest<TraktRating>(
        "shows/{id}/seasons/{season}/ratings",
        TraktRating::class
)

internal class SeasonsAllRequest(
        override var id: String,
        internal var translationLanguageCode: String?,
        override var extendedInfo: TraktExtendedInfo?
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
        override var seasonNumber: Int,
        internal var translationLanguageCode: String?,
        override var extendedInfo: TraktExtendedInfo?
) : ASeasonRequest<TraktEpisode>(
        "shows/{id}/seasons/{season}{?extended,translations}",
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
        override var seasonNumber: Int
) : ASeasonRequest<TraktStatistics>(
        "shows/{id}/seasons/{season}/stats",
        TraktStatistics::class
)

internal class SeasonWatchingUsersRequest(
        override var id: String,
        override var seasonNumber: Int,
        override var extendedInfo: TraktExtendedInfo?
) : ASeasonRequest<TraktUser>(
        "shows/{id}/seasons/{season}/watching{?extended}",
        TraktUser::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}