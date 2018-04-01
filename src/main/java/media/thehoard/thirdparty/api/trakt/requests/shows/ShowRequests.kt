package media.thehoard.thirdparty.api.trakt.requests.shows

import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
import media.thehoard.thirdparty.api.trakt.enums.TraktTimePeriod
import media.thehoard.thirdparty.api.trakt.extensions.containsSpace
import media.thehoard.thirdparty.api.trakt.extensions.toTraktDateString
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCastAndCrewImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktRatingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktRecentlyUpdatedShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowAliasImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
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
import java.time.Instant
import java.util.*

internal sealed class AShowRequest<TResponseContentType>(
        override val uriTemplate: String,
        override var id: String
) : AGetRequestHasResponse<TResponseContentType>(), IHasId {
    override val requestObjectType: RequestObjectType = RequestObjectType.Movies

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate() {
        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("show id is not valid")
    }
}

internal sealed class AShowsMostPWCRequest<TResponseContentType>(
        override val uriTemplate: String,
        override var id: String,
        internal var period: TraktTimePeriod? = null
) : AShowRequest<TResponseContentType>(uriTemplate, id) {
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
        override var limit: Int? = null
) : AGetRequestHasResponse<TResponseContentType>(), ISupportsExtendedInfo, ISupportsFilter, ISupportsPagination {
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
        id
)

internal class ShowCommentsRequest(
        override var id: String,
        internal var sortOrder: TraktCommentSortOrder? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AShowRequest<TraktCommentImpl>(
        "shows/{id}/comments{/sort_order}{?page,limit}",
        id
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
        id
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
) : AShowRequest<TraktListImpl>("shows/{id}/lists{/type}{/sort_order}{?page,limit}", id), ISupportsPagination {
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
        id
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
        id
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
        id
)

internal class ShowRelatedShowsRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AShowRequest<TraktShowImpl>(
        "shows/{id}/related{?extended,page,limit}",
        id
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

internal class ShowsMostAnticipatedRequest : AShowsRequest<TraktMostAnticipatedMovieImpl>(
        "shows/anticipated{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}"
) {
    override fun validate() {}
}

internal class ShowsMostCollectedRequest(
        override var id: String
) : AShowsMostPWCRequest<TraktMostPWCMovieImpl>(
        "shows/collected{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        id
) {
    override fun validate() {}
}

internal class ShowsMostPlayedRequest(
        override var id: String
) : AShowsMostPWCRequest<TraktMostPWCMovieImpl>(
        "shows/played{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        id
) {
    override fun validate() {}
}

internal class ShowsMostWatchedRequest(
        override var id: String
) : AShowsMostPWCRequest<TraktMostPWCMovieImpl>(
        "shows/watched{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        id
) {
    override fun validate() {}
}

internal class ShowsPopularRequest(
        override var id: String
) : AShowsMostPWCRequest<TraktMostPWCMovieImpl>(
        "shows/popular{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}",
        id
) {
    override fun validate() {}
}

internal class ShowsRecentlyUpdatedRequest(
        internal var startDate: Instant? = null,
        override var extendedInfo: TraktExtendedInfo? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AGetRequestHasResponse<TraktRecentlyUpdatedShowImpl>(), ISupportsExtendedInfo, ISupportsPagination {
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

    override fun validate() {}
}

internal class ShowStatisticsRequest(
        override var id: String
) : AShowRequest<TraktRatingImpl>(
        "shows/{id}/stats",
        id
)

internal class ShowsTrendingRequest : AShowsRequest<TraktTrendingMovieImpl>(
        "shows/trending{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications,networks,status}"
) {
    override fun validate() {}
}

internal class ShowSummaryRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null
) : AShowRequest<TraktMovieImpl>("shows/{id}{?extended}", id), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class ShowTranslationsRequest(
        override var id: String,
        var languageCode: String? = null
) : AShowRequest<TraktMovieTranslationImpl>(
        "shows/{id}/translations{/language}",
        id
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (!languageCode.isNullOrBlank())
                this["language"] = languageCode!!
        }

    override fun validate() {
        super.validate()
        if (languageCode != null && languageCode!!.length != 2)
            throw IllegalArgumentException("language code has wrong length")
    }
}

internal class ShowWatchingUsersRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null
) : AShowRequest<TraktUserImpl>(
        "shows/{id}/watching{?extended}",
        id
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}