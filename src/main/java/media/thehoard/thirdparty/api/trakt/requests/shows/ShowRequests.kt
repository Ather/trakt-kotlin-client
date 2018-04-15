package media.thehoard.thirdparty.api.trakt.requests.shows

import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
import media.thehoard.thirdparty.api.trakt.enums.TraktTimePeriod
import media.thehoard.thirdparty.api.trakt.extensions.isValidStringId
import media.thehoard.thirdparty.api.trakt.extensions.isValidTwoCharCode
import media.thehoard.thirdparty.api.trakt.extensions.toTraktDateString
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCastAndCrew
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktComment
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktRating
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktStatistics
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.shows.*
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsFilter
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsPagination
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktCommonFilter
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.time.ZonedDateTime
import java.util.*
import kotlin.reflect.KClass

internal sealed class AShowRequest<TResponseContentType>(
        override val uriTemplate: String,
        responseContentClass: KClass<*>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), IHasId {
    override val requestObjectType: RequestObjectType = RequestObjectType.Movies

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate(variableName: String) = id.validate("show id", ::isValidStringId)
}

internal sealed class AShowsMostPWCRequest<TResponseContentType>(
        override val uriTemplate: String,
        responseContentClass: KClass<*>
) : AShowsRequest<TResponseContentType>(uriTemplate, responseContentClass) {
    internal abstract var period: TraktTimePeriod?

    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (period != null && period != TraktTimePeriod.UNSPECIFIED)
                this["period"] = period!!.uriName
        }
}

internal sealed class AShowsRequest<TResponseContentType>(
        override val uriTemplate: String,
        responseContentClass: KClass<*>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), ISupportsExtendedInfo, ISupportsFilter, ISupportsPagination {
    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf<String, String>().apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
            if (filter != null && filter!!.hasValues)
                for (parameter in filter!!.getParameters())
                    this[parameter.key] = parameter.value
            if (page != null)
                this["page"] = page!!.toString()
            if (limit != null)
                this["limit"] = limit!!.toString()
        }
}

internal class ShowAliasesRequest(
        override var id: String
) : AShowRequest<TraktShowAlias>(
        "shows/{id}/aliases",
        TraktShowAlias::class
)

internal class ShowCommentsRequest(
        override var id: String,
        internal var sortOrder: TraktCommentSortOrder?,
        override var page: Int?,
        override var limit: Int?
) : AShowRequest<TraktComment>(
        "shows/{id}/comments{/sort_order}{?page,limit}",
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

internal class ShowLastEpisodeRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo?
) : AShowRequest<TraktEpisode>(
        "shows/{id}/last_episode{?extended}",
        TraktEpisode::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class ShowListsRequest(
        override var id: String,
        internal var type: TraktListType?,
        internal var sortOrder: TraktListSortOrder?,
        override var page: Int?,
        override var limit: Int?
) : AShowRequest<TraktList>(
        "shows/{id}/lists{/type}{/sort_order}{?page,limit}",
        TraktList::class
), ISupportsPagination {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            val isTypeSetAndValid = type != null && type != TraktListType.UNSPECIFIED
            if (isTypeSetAndValid)
                this["type"] = type!!.uriName
            if (isTypeSetAndValid && sortOrder != null && sortOrder != TraktListSortOrder.UNSPECIFIED)
                this["sort_order"] = sortOrder!!.uriName
            if (page != null)
                this["page"] = page!!.toString()
            if (limit != null)
                this["limit"] = limit!!.toString()
        }
}

internal class ShowNextEpisodeRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo?
) : AShowRequest<TraktEpisode>(
        "shows/{id}/next_episode{?extended}",
        TraktEpisode::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class ShowPeopleRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo?
) : AShowRequest<TraktCastAndCrew>(
        "shows/{id}/people{?extended}",
        TraktCastAndCrew::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class ShowRatingsRequest(
        override var id: String
) : AShowRequest<TraktRating>(
        "shows/{id}/ratings",
        TraktRating::class
)

internal class ShowRelatedShowsRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo?,
        override var page: Int?,
        override var limit: Int?
) : AShowRequest<TraktShow>(
        "shows/{id}/related{?extended,page,limit}",
        TraktShow::class
), ISupportsExtendedInfo, ISupportsPagination {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
            if (page != null)
                this["page"] = page!!.toString()
            if (limit != null)
                this["limit"] = limit!!.toString()
        }
}

internal class ShowsMostAnticipatedRequest(
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?,
        override var page: Int?,
        override var limit: Int?
) : AShowsRequest<TraktMostAnticipatedShow>(
        "shows/anticipated{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        TraktMostAnticipatedShow::class
) {
    override fun validate(variableName: String) {}
}

internal class ShowsMostCollectedRequest(
        override var period: TraktTimePeriod?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?,
        override var page: Int?,
        override var limit: Int?
) : AShowsMostPWCRequest<TraktMostPWCShow>(
        "shows/collected{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        TraktMostPWCShow::class
) {
    override fun validate(variableName: String) {}
}

internal class ShowsMostPlayedRequest(
        override var period: TraktTimePeriod?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?,
        override var page: Int?,
        override var limit: Int?
) : AShowsMostPWCRequest<TraktMostPWCShow>(
        "shows/played{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        TraktMostPWCShow::class
) {
    override fun validate(variableName: String) {}
}

internal class ShowsMostWatchedRequest(
        override var period: TraktTimePeriod?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?,
        override var page: Int?,
        override var limit: Int?
) : AShowsMostPWCRequest<TraktMostPWCShow>(
        "shows/watched{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        TraktMostPWCShow::class
) {
    override fun validate(variableName: String) {}
}

internal class ShowsPopularRequest(
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?,
        override var page: Int?,
        override var limit: Int?
) : AShowsRequest<TraktShow>(
        "shows/popular{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        TraktShow::class
) {
    override fun validate(variableName: String) {}
}

internal class ShowsRecentlyUpdatedRequest(
        internal var startDate: ZonedDateTime? = null,
        override var extendedInfo: TraktExtendedInfo? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AGetRequestHasResponse<TraktRecentlyUpdatedShow>(TraktRecentlyUpdatedShow::class), ISupportsExtendedInfo, ISupportsPagination {
    override val uriTemplate: String = "shows/updates{/start_date}{?extended,page,limit}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf<String, String>().apply {
            if (startDate != null)
                this["start_date"] = startDate!!.toTraktDateString()
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
            if (page != null)
                this["page"] = page!!.toString()
            if (limit != null)
                this["limit"] = limit!!.toString()
        }

    override fun validate(variableName: String) {}
}

internal class ShowStatisticsRequest(
        override var id: String
) : AShowRequest<TraktStatistics>(
        "shows/{id}/stats",
        TraktStatistics::class
)

internal class ShowsTrendingRequest(
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?,
        override var page: Int?,
        override var limit: Int?
) : AShowsRequest<TraktTrendingShow>(
        "shows/trending{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        TraktTrendingShow::class
) {
    override fun validate(variableName: String) {}
}

internal class ShowSummaryRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo?
) : AShowRequest<TraktShow>(
        "shows/{id}{?extended}",
        TraktShow::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class ShowTranslationsRequest(
        override var id: String,
        var languageCode: String?
) : AShowRequest<TraktShowTranslation>(
        "shows/{id}/translations{/language}",
        TraktShowTranslation::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (!languageCode.isNullOrBlank())
                this["language"] = languageCode!!
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        languageCode.validate("language code has wrong length", ::isValidTwoCharCode)
    }
}

internal class ShowWatchingUsersRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo?
) : AShowRequest<TraktUser>(
        "shows/{id}/watching{?extended}",
        TraktUser::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}