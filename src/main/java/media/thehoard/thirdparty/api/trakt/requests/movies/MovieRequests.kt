package media.thehoard.thirdparty.api.trakt.requests.movies

import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
import media.thehoard.thirdparty.api.trakt.enums.TraktTimePeriod
import media.thehoard.thirdparty.api.trakt.extensions.*
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCastAndCrewImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktRatingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.*
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

internal sealed class AMovieRequest<TResponseContentType>(
        override val uriTemplate: String,
        override var id: String,
        responseContentClass: KClass<*>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), IHasId {
    override val requestObjectType: RequestObjectType = RequestObjectType.Movies

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate(variableName: String) = id.validate("movie id", ::isValidStringId)
}

internal sealed class AMoviesMostPWCRequest<TResponseContentType>(
        override val uriTemplate: String,
        internal var period: TraktTimePeriod? = null,
        responseContentClass: KClass<*>
) : AMovieRequest<TResponseContentType>(uriTemplate, "", responseContentClass) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (period != null && period != TraktTimePeriod.UNSPECIFIED)
                this["period"] = period!!.uriName
        }
}

internal sealed class AMoviesRequest<TResponseContentType>(
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

internal class MovieAliasesRequest(
        override var id: String
) : AMovieRequest<TraktMovieAliasImpl>(
        "movies/{id}/aliases",
        id,
        TraktMovieAliasImpl::class
)

internal class MovieCommentsRequest(
        override var id: String,
        internal var sortOrder: TraktCommentSortOrder? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AMovieRequest<TraktCommentImpl>(
        "movies/{id}/comments{/sort_order}{?page,limit}",
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

internal class MovieListsRequest(
        override var id: String,
        internal var type: TraktListType? = null,
        internal var sortOrder: TraktListSortOrder? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AMovieRequest<TraktListImpl>(
        "movies/{id}/lists{/type}{/sort_order}{?page,limit}",
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

internal class MoviePeopleRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null
) : AMovieRequest<TraktCastAndCrewImpl>(
        "movies/{id}/people{?extended}",
        id,
        TraktCastAndCrewImpl::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class MovieRatingsRequest(
        override var id: String
) : AMovieRequest<TraktRatingImpl>(
        "movies/{id}/ratings",
        id,
        TraktRatingImpl::class
)

internal class MovieRelatedMoviesRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AMovieRequest<TraktMovieImpl>(
        "movies/{id}/related{?extended,page,limit}",
        id,
        TraktMovieImpl::class
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

internal class MovieReleasesRequest(
        override var id: String,
        var countryCode: String? = null
) : AMovieRequest<TraktMovieReleaseImpl>(
        "movies/{id}/releases{/country}",
        id,
        TraktMovieReleaseImpl::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (!countryCode.isNullOrBlank())
                this["country"] = countryCode!!
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        countryCode.validate("country code has wrong length", ::isValidTwoCharCode, null)
    }
}

internal class MoviesBoxOfficeRequest(
        override var extendedInfo: TraktExtendedInfo? = null
) : AGetRequestHasResponse<TraktCastAndCrewImpl>(TraktCastAndCrewImpl::class), ISupportsExtendedInfo {
    override val uriTemplate: String = "movies/boxoffice{?extended}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf<String, String>().apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }

    override fun validate(variableName: String) {}
}

internal class MoviesMostAnticipatedRequest : AMoviesRequest<TraktMostAnticipatedMovieImpl>(
        "movies/anticipated{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        responseContentClass = TraktMostAnticipatedMovieImpl::class
) {
    override fun validate(variableName: String) {}
}

internal class MoviesMostCollectedRequest : AMoviesMostPWCRequest<TraktMostPWCMovieImpl>(
        "movies/collected{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        responseContentClass = TraktMostPWCMovieImpl::class
) {
    override fun validate(variableName: String) {}
}

internal class MoviesMostPlayedRequest : AMoviesMostPWCRequest<TraktMostPWCMovieImpl>(
        "movies/played{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        responseContentClass = TraktMostPWCMovieImpl::class
) {
    override fun validate(variableName: String) {}
}

internal class MoviesMostWatchedRequest : AMoviesMostPWCRequest<TraktMostPWCMovieImpl>(
        "movies/watched{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        responseContentClass = TraktMostPWCMovieImpl::class
) {
    override fun validate(variableName: String) {}
}

internal class MoviesPopularRequest : AMoviesMostPWCRequest<TraktMostPWCMovieImpl>(
        "movies/popular{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        responseContentClass = TraktMostPWCMovieImpl::class
) {
    override fun validate(variableName: String) {}
}

internal class MoviesRecentlyUpdatedRequest(
        internal var startDate: ZonedDateTime? = null,
        override var extendedInfo: TraktExtendedInfo? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AGetRequestHasResponse<TraktRecentlyUpdatedMovieImpl>(TraktRecentlyUpdatedMovieImpl::class), ISupportsExtendedInfo, ISupportsPagination {
    override val uriTemplate: String = "movies/updates{/start_date}{?extended,page,limit}"

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

internal class MovieStatisticsRequest(
        override var id: String
) : AMovieRequest<TraktRatingImpl>(
        "movies/{id}/stats",
        id,
        TraktRatingImpl::class
)

internal class MoviesTrendingRequest : AMoviesRequest<TraktTrendingMovieImpl>(
        "movies/trending{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        responseContentClass = TraktTrendingMovieImpl::class
) {
    override fun validate(variableName: String) {}
}

internal class MovieSummaryRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null
) : AMovieRequest<TraktMovieImpl>(
        "movies/{id}{?extended}",
        id,
        responseContentClass = TraktMovieImpl::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class MovieTranslationsRequest(
        override var id: String,
        var languageCode: String? = null
) : AMovieRequest<TraktMovieTranslationImpl>(
        "movies/{id}/translations{/language}",
        id,
        responseContentClass = TraktMovieTranslationImpl::class
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (!languageCode.isNullOrBlank())
                this["language"] = languageCode!!
        }

    override fun validate(variableName: String) {
        super.validate(variableName)
        languageCode.validate("language code has wrong length", ::isValidTwoCharCode, null)
    }
}

internal class MovieWatchingUsersRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null
) : AMovieRequest<TraktUserImpl>(
        "movies/{id}/watching{?extended}",
        id,
        responseContentClass = TraktUserImpl::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}