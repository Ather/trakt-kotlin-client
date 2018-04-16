package media.thehoard.thirdparty.api.trakt.requests.movies

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
import media.thehoard.thirdparty.api.trakt.objects.get.movies.*
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

internal sealed class AMovieRequest<TResponseContentType : Any>(
        override val uriTemplate: String,
        responseContentClass: KClass<TResponseContentType>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), IHasId {
    override val requestObjectType: RequestObjectType = RequestObjectType.Movies

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate(variableName: String) = id.validate("movie id", ::isValidStringId)
}

internal sealed class AMoviesMostPWCRequest<TResponseContentType : Any>(
        uriTemplate: String,
        var period: TraktTimePeriod?,
        responseContentClass: KClass<TResponseContentType>
) : AMoviesRequest<TResponseContentType>(
        uriTemplate,
        responseContentClass
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (period != null && period != TraktTimePeriod.UNSPECIFIED)
                this["period"] = period!!.uriName
        }
}

internal sealed class AMoviesRequest<TResponseContentType : Any>(
        override val uriTemplate: String,
        responseContentClass: KClass<TResponseContentType>
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
) : AMovieRequest<TraktMovieAlias>(
        "movies/{id}/aliases",
        TraktMovieAlias::class
)

internal class MovieCommentsRequest(
        override var id: String,
        internal var sortOrder: TraktCommentSortOrder?,
        override var page: Int?,
        override var limit: Int?
) : AMovieRequest<TraktComment>(
        "movies/{id}/comments{/sort_order}{?page,limit}",
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

internal class MovieListsRequest(
        override var id: String,
        internal var type: TraktListType?,
        internal var sortOrder: TraktListSortOrder?,
        override var page: Int?,
        override var limit: Int?
) : AMovieRequest<TraktList>(
        "movies/{id}/lists{/type}{/sort_order}{?page,limit}",
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

internal class MoviePeopleRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo?
) : AMovieRequest<TraktCastAndCrew>(
        "movies/{id}/people{?extended}",
        TraktCastAndCrew::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class MovieRatingsRequest(
        override var id: String
) : AMovieRequest<TraktRating>(
        "movies/{id}/ratings",
        TraktRating::class
)

internal class MovieRelatedMoviesRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo?,
        override var page: Int?,
        override var limit: Int?
) : AMovieRequest<TraktMovie>(
        "movies/{id}/related{?extended,page,limit}",
        TraktMovie::class
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
        var countryCode: String?
) : AMovieRequest<TraktMovieRelease>(
        "movies/{id}/releases{/country}",
        TraktMovieRelease::class
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
        override var extendedInfo: TraktExtendedInfo?
) : AGetRequestHasResponse<TraktBoxOfficeMovie>(TraktBoxOfficeMovie::class), ISupportsExtendedInfo {
    override val uriTemplate: String = "movies/boxoffice{?extended}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf<String, String>().apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }

    override fun validate(variableName: String) {}
}

internal class MoviesMostAnticipatedRequest(
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?,
        override var page: Int?,
        override var limit: Int?
) : AMoviesRequest<TraktMostAnticipatedMovie>(
        "movies/anticipated{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        TraktMostAnticipatedMovie::class
) {
    override fun validate(variableName: String) {}
}

internal class MoviesMostCollectedRequest(
        period: TraktTimePeriod?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?,
        override var page: Int?,
        override var limit: Int?
) : AMoviesMostPWCRequest<TraktMostPWCMovie>(
        "movies/collected{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        period,
        TraktMostPWCMovie::class
) {
    override fun validate(variableName: String) {}
}

internal class MoviesMostPlayedRequest(
        period: TraktTimePeriod?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?,
        override var page: Int?,
        override var limit: Int?
) : AMoviesMostPWCRequest<TraktMostPWCMovie>(
        "movies/played{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        period,
        TraktMostPWCMovie::class
) {
    override fun validate(variableName: String) {}
}

internal class MoviesMostWatchedRequest(
        period: TraktTimePeriod?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?,
        override var page: Int?,
        override var limit: Int?
) : AMoviesMostPWCRequest<TraktMostPWCMovie>(
        "movies/watched{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        period,
        TraktMostPWCMovie::class
) {
    override fun validate(variableName: String) {}
}

internal class MoviesPopularRequest(
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?,
        override var page: Int?,
        override var limit: Int?
) : AMoviesRequest<TraktMovie>(
        "movies/popular{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        TraktMovie::class
) {
    override fun validate(variableName: String) {}
}

internal class MoviesRecentlyUpdatedRequest(
        internal var startDate: ZonedDateTime?,
        override var extendedInfo: TraktExtendedInfo?,
        override var page: Int?,
        override var limit: Int?
) : AGetRequestHasResponse<TraktRecentlyUpdatedMovie>(TraktRecentlyUpdatedMovie::class), ISupportsExtendedInfo, ISupportsPagination {
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
) : AMovieRequest<TraktStatistics>(
        "movies/{id}/stats",
        TraktStatistics::class
)

internal class MoviesTrendingRequest(
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?,
        override var page: Int?,
        override var limit: Int?
) : AMoviesRequest<TraktTrendingMovie>(
        "movies/trending{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        TraktTrendingMovie::class
) {
    override fun validate(variableName: String) {}
}

internal class MovieSummaryRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo?
) : AMovieRequest<TraktMovie>(
        "movies/{id}{?extended}",
        TraktMovie::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class MovieTranslationsRequest(
        override var id: String,
        var languageCode: String?
) : AMovieRequest<TraktMovieTranslation>(
        "movies/{id}/translations{/language}",
        TraktMovieTranslation::class
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
) : AMovieRequest<TraktUser>(
        "movies/{id}/watching{?extended}",
        TraktUser::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}