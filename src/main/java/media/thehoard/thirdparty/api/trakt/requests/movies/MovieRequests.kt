package media.thehoard.thirdparty.api.trakt.requests.movies

import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
import media.thehoard.thirdparty.api.trakt.enums.TraktTimePeriod
import media.thehoard.thirdparty.api.trakt.extensions.containsSpace
import media.thehoard.thirdparty.api.trakt.extensions.toTraktDateString
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCastAndCrewImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktRatingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserExtendedFullImpl
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

internal sealed class AMovieRequest<TResponseContentType>(
        override val uriTemplate: String,
        override var id: String
) : AGetRequestHasResponse<TResponseContentType>(), IHasId {
    override val requestObjectType: RequestObjectType = RequestObjectType.Movies

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id)

    override fun validate() {
        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("movie id is not valid")
    }
}

internal sealed class AMoviesMostPWCRequest<TResponseContentType>(
        override val uriTemplate: String,
        override var id: String,
        internal var period: TraktTimePeriod? = null
) : AMovieRequest<TResponseContentType>(uriTemplate, id) {
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

internal class MovieAliasesRequest(
        override var id: String
) : AMovieRequest<TraktMovieAliasImpl>(
        "movies/{id}/aliases",
        id
)

internal class MovieCommentsRequest(
        override var id: String,
        internal var sortOrder: TraktCommentSortOrder? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AMovieRequest<TraktCommentImpl>(
        "movies/{id}/comments{/sort_order}{?page,limit}",
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

internal class MovieListsRequest(
        override var id: String,
        internal var type: TraktListType? = null,
        internal var sortOrder: TraktListSortOrder? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AMovieRequest<TraktListImpl>("movies/{id}/lists{/type}{/sort_order}{?page,limit}", id), ISupportsPagination {
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
) : AMovieRequest<TraktCastAndCrewImpl>("movies/{id}/people{?extended}", id), ISupportsExtendedInfo {
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
        id
)

internal class MovieRelatedMoviesRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AMovieRequest<TraktMovieExtendedFullImpl>(
        "movies/{id}/related{?extended,page,limit}",
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

internal class MovieReleasesRequest(
        override var id: String,
        var countryCode: String? = null
) : AMovieRequest<TraktMovieReleaseImpl>("movies/{id}/releases{/country}", id) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (!countryCode.isNullOrBlank())
                this["country"] = countryCode!!
        }

    override fun validate() {
        super.validate()
        if (countryCode != null && countryCode!!.length != 2)
            throw IllegalArgumentException("country code has wrong length")
    }
}

internal class MoviesBoxOfficRequest(
        override var extendedInfo: TraktExtendedInfo? = null
) : AGetRequestHasResponse<TraktCastAndCrewImpl>(), ISupportsExtendedInfo {
    override val uriTemplate: String = "movies/boxoffice{?extended}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf<String, String>().apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }

    override fun validate() {}
}

internal class MoviesMostAnticipatedRequest : AMoviesRequest<TraktMostAnticipatedMovieImpl>(
        "movies/anticipated{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}"
) {
    override fun validate() {}
}

internal class MoviesMostCollectedRequest(
        override var id: String
) : AMoviesMostPWCRequest<TraktMostPWCMovieImpl>(
        "movies/collected{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        id
) {
    override fun validate() {}
}

internal class MoviesMostPlayedRequest(
        override var id: String
) : AMoviesMostPWCRequest<TraktMostPWCMovieImpl>(
        "movies/played{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        id
) {
    override fun validate() {}
}

internal class MoviesMostWatchedRequest(
        override var id: String
) : AMoviesMostPWCRequest<TraktMostPWCMovieImpl>(
        "movies/watched{/period}{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        id
) {
    override fun validate() {}
}

internal class MoviesPopularRequest(
        override var id: String
) : AMoviesMostPWCRequest<TraktMostPWCMovieImpl>(
        "movies/popular{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}",
        id
) {
    override fun validate() {}
}

internal class MoviesRecentlyUpdatedRequest(
        internal var startDate: Instant? = null,
        override var extendedInfo: TraktExtendedInfo? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AGetRequestHasResponse<TraktRecentlyUpdatedMovieImpl>(), ISupportsExtendedInfo, ISupportsPagination {
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

    override fun validate() {}
}

internal class MovieStatisticsRequest(
        override var id: String
) : AMovieRequest<TraktRatingImpl>(
        "movies/{id}/stats",
        id
)

internal class MoviesTrendingRequest : AMoviesRequest<TraktTrendingMovieImpl>(
        "movies/trending{?extended,page,limit,query,years,genres,languages,countries,runtimes,ratings,certifications}"
) {
    override fun validate() {}
}

internal class MovieSummaryRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null
) : AMovieRequest<TraktMovieExtendedFullImpl>("movies/{id}{?extended}", id), ISupportsExtendedInfo {
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

internal class MovieWatchingUsersRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null
) : AMovieRequest<TraktUserExtendedFullImpl>(
        "movies/{id}/watching{?extended}",
        id
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}