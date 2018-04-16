package media.thehoard.thirdparty.api.trakt.requests.episodes

import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
import media.thehoard.thirdparty.api.trakt.extensions.isNotNegative
import media.thehoard.thirdparty.api.trakt.extensions.isPositive
import media.thehoard.thirdparty.api.trakt.extensions.isValidTwoCharCode
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktComment
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktRating
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktStatistics
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeTranslation
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

internal sealed class AEpisodeRequest<TResponseContentType : Any>(
        override val uriTemplate: String,
        responseContentClass: KClass<TResponseContentType>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), IHasId {
    internal abstract var seasonNumber: Int

    internal abstract var episodeNumber: Int

    override val requestObjectType: RequestObjectType = RequestObjectType.Episodes

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id, "season" to seasonNumber.toString(), "episode" to episodeNumber.toString())

    override fun validate(variableName: String) {
        id.validate("show id", String::isNotBlank)
        seasonNumber.validate("season number must be a non-negative integer", ::isNotNegative, null)
        episodeNumber.validate("episode number must be a positive integer greater than 0", ::isPositive, null)
    }
}

internal class EpisodeCommentsRequest(
        override var id: String,
        override var seasonNumber: Int,
        override var episodeNumber: Int,
        internal var sortOrder: TraktCommentSortOrder?,
        override var page: Int?,
        override var limit: Int?
) : AEpisodeRequest<TraktComment>(
        "shows/{id}/seasons/{season}/episodes/{episode}/comments{/sort_order}{?page,limit}",
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

internal class EpisodeListsRequest(
        override var id: String,
        override var seasonNumber: Int,
        override var episodeNumber: Int,
        internal var type: TraktListType?,
        internal var sortOrder: TraktListSortOrder?,
        override var page: Int?,
        override var limit: Int?
) : AEpisodeRequest<TraktList>(
        "shows/{id}/seasons/{season}/episodes/{episode}/lists{/type}{/sort_order}{?page,limit}",
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

internal class EpisodeRatingsRequest(
        override var id: String,
        override var seasonNumber: Int,
        override var episodeNumber: Int
) : AEpisodeRequest<TraktRating>(
        "shows/{id}/seasons/{season}/episodes/{episode}/ratings",
        TraktRating::class
)

internal class EpisodeStatisticsRequest(
        override var id: String,
        override var seasonNumber: Int,
        override var episodeNumber: Int
) : AEpisodeRequest<TraktStatistics>(
        "shows/{id}/seasons/{season}/episodes/{episode}/stats",
        TraktStatistics::class
)

internal class EpisodeSummaryRequest(
        override var id: String,
        override var seasonNumber: Int,
        override var episodeNumber: Int,
        override var extendedInfo: TraktExtendedInfo?
) : AEpisodeRequest<TraktEpisode>(
        "shows/{id}/seasons/{season}/episodes/{episode}{?extended}",
        TraktEpisode::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class EpisodeTranslationsRequest(
        override var id: String,
        override var seasonNumber: Int,
        override var episodeNumber: Int,
        internal var languageCode: String?
) : AEpisodeRequest<TraktEpisodeTranslation>(
        "shows/{id}/seasons/{season}/episodes/{episode}/translations{/language}",
        TraktEpisodeTranslation::class
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

internal class EpisodeWatchingUsersRequest(
        override var id: String,
        override var seasonNumber: Int,
        override var episodeNumber: Int,
        override var extendedInfo: TraktExtendedInfo?
) : AEpisodeRequest<TraktUser>(
        "shows/{id}/seasons/{season}/episodes/{episode}/watching{?extended}",
        TraktUser::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}