package media.thehoard.thirdparty.api.trakt.requests.shows

import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
import media.thehoard.thirdparty.api.trakt.enums.TraktTimePeriod
import media.thehoard.thirdparty.api.trakt.extensions.*
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCastAndCrewImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktRatingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMostPWCMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl
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
        override var id: String,
        responseContentClass: KClass<*>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), IHasId {
    override val requestObjectType: RequestObjectType = RequestObjectType.Movies

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate(variableName: String) = id.validate("show id", ::isValidStringId)
}

internal sealed class AShowsMostPWCRequest<TResponseContentType>(
        override val uriTemplate: String,
        internal var period: TraktTimePeriod? = null,
        responseContentClass: KClass<*>
) : AShowRequest<TResponseContentType>(uriTemplate, "", responseContentClass) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (period != null && period != TraktTimePeriod.UNSPECIFIED)
                this["period"] = period!!.uriName
        }
}

internal sealed class AShowsRequest<TResponseContentType>(
        override val uriTemplate: String,
        override var extendedInfo: TraktExtendedInfo? = null,
        override var filter: TraktCommonFilter? = null,
        override var page: Int? = null,
        override var limit: Int? = null,
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
) : AShowRequest<TraktShowAliasImpl>(
        "shows/{id}/aliases",
        id,
        TraktShowAliasImpl::class
)

internal class ShowCommentsRequest(
        override var id: String,
        internal var sortOrder: TraktCommentSortOrder? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AShowRequest<TraktCommentImpl>(
        "shows/{id}/comments{/sort_order}{?page,limit}",
        id,
        TraktCommentImpl::class
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
        override var extendedInfo: TraktExtendedInfo? = null
) : AShowRequest<TraktEpisodeImpl>(
        "shows/{id}/last_episode{?extended}",
        id,
        TraktEpisodeImpl::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class ShowListsRequest(
        override var id: String,
        internal var type: TraktListType? = null,
        internal var sortOrder: TraktListSortOrder? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AShowRequest<TraktListImpl>(
        "shows/{id}/lists{/type}{/sort_order}{?page,limit}",
        id,
        TraktListImpl::class
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
        override var extendedInfo: TraktExtendedInfo? = null
) : AShowRequest<TraktEpisodeImpl>(
        "shows/{id}/next_episode{?extended}",
        id,
        TraktEpisodeImpl::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class ShowPeopleRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null
) : AShowRequest<TraktCastAndCrewImpl>(
        "shows/{id}/people{?extended}",
        id,
        TraktCastAndCrewImpl::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class ShowRatingsRequest(
        override var id: String
) : AShowRequest<TraktRatingImpl>(
        "shows/{id}/ratings",
        id,
        TraktRatingImpl::class
)

internal class ShowRelatedShowsRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AShowRequest<TraktShowImpl>(
        "shows/{id}/related{?extended,page,limit}",
        id,
        TraktShowImpl::class
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

internal class ShowsMostAnticipatedRequest : AShowsRequest<TraktMostAnticipatedShowImpl>(
        "shows/anticipated{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        responseContentClass = TraktMostAnticipatedShowImpl::class
) {
    override fun validate(variableName: String) {}
}

internal class ShowsMostCollectedRequest : AShowsMostPWCRequest<TraktMostPWCShowImpl>(
        "shows/collected{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        responseContentClass = TraktMostPWCShowImpl::class
) {
    override fun validate(variableName: String) {}
}

internal class ShowsMostPlayedRequest : AShowsMostPWCRequest<TraktMostPWCShowImpl>(
        "shows/played{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        responseContentClass = TraktMostPWCShowImpl::class
) {
    override fun validate(variableName: String) {}
}

internal class ShowsMostWatchedRequest : AShowsMostPWCRequest<TraktMostPWCShowImpl>(
        "shows/watched{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        responseContentClass = TraktMostPWCShowImpl::class
) {
    override fun validate(variableName: String) {}
}

internal class ShowsPopularRequest : AShowsMostPWCRequest<TraktMostPWCMovieImpl>(
        "shows/popular{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        responseContentClass = TraktMostPWCMovieImpl::class
) {
    override fun validate(variableName: String) {}
}

internal class ShowsRecentlyUpdatedRequest(
        internal var startDate: ZonedDateTime? = null,
        override var extendedInfo: TraktExtendedInfo? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AGetRequestHasResponse<TraktRecentlyUpdatedShowImpl>(TraktRecentlyUpdatedShowImpl::class), ISupportsExtendedInfo, ISupportsPagination {
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
) : AShowRequest<TraktRatingImpl>(
        "shows/{id}/stats",
        id,
        responseContentClass = TraktRatingImpl::class
)

internal class ShowsTrendingRequest : AShowsRequest<TraktTrendingShowImpl>(
        "shows/trending{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        responseContentClass = TraktTrendingShowImpl::class
) {
    override fun validate(variableName: String) {}
}

internal class ShowSummaryRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null
) : AShowRequest<TraktShowImpl>(
        "shows/{id}{?extended}",
        id,
        TraktShowImpl::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class ShowTranslationsRequest(
        override var id: String,
        var languageCode: String? = null
) : AShowRequest<TraktShowTranslationImpl>(
        "shows/{id}/translations{/language}",
        id,
        responseContentClass = TraktShowTranslationImpl::class
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
        override var extendedInfo: TraktExtendedInfo? = null
) : AShowRequest<TraktUserImpl>(
        "shows/{id}/watching{?extended}",
        id,
        responseContentClass = TraktUserImpl::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}