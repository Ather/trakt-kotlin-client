package media.thehoard.thirdparty.api.trakt.requests.episodes

import media.thehoard.thirdparty.api.trakt.enums.TraktCommentSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortOrder
import media.thehoard.thirdparty.api.trakt.enums.TraktListType
import media.thehoard.thirdparty.api.trakt.extensions.isNotNegative
import media.thehoard.thirdparty.api.trakt.extensions.isPositive
import media.thehoard.thirdparty.api.trakt.extensions.isValidTwoCharCode
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktRatingImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktStatisticsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsPagination
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.util.*
import kotlin.reflect.KClass

internal sealed class AEpisodeRequest<TResponseContentType>(
        override val uriTemplate: String,
        override var id: String,
        internal var seasonNumber: Int,
        internal var episodeNumber: Int,
        responseContentClass: KClass<*>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), IHasId {

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
        seasonNumber: Int,
        episodeNumber: Int,
        internal var sortOrder: TraktCommentSortOrder? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AEpisodeRequest<TraktCommentImpl>(
        "shows/{id}/seasons/{season}/episodes/{episode}/comments{/sort_order}{?page,limit}",
        id,
        seasonNumber,
        episodeNumber,
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

internal class EpisodeListRequest(
        override var id: String,
        seasonNumber: Int,
        episodeNumber: Int,
        internal var type: TraktListType? = null,
        internal var sortOrder: TraktListSortOrder? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AEpisodeRequest<TraktListImpl>(
        "shows/{id}/seasons/{season}/episodes/{episode}/lists{/type}{/sort_order}{?page,limit}",
        id,
        seasonNumber,
        episodeNumber,
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

internal class EpisodeRatingsRequest(
        override var id: String,
        seasonNumber: Int,
        episodeNumber: Int
) : AEpisodeRequest<TraktRatingImpl>(
        "shows/{id}/seasons/{season}/episodes/{episode}/ratings",
        id,
        seasonNumber,
        episodeNumber,
        TraktRatingImpl::class
)

internal class EpisodeStatisticsRequest(
        override var id: String,
        seasonNumber: Int,
        episodeNumber: Int
) : AEpisodeRequest<TraktStatisticsImpl>(
        "shows/{id}/seasons/{season}/episodes/{episode}/stats",
        id,
        seasonNumber,
        episodeNumber,
        TraktStatisticsImpl::class
)

internal class EpisodeSummaryRequest(
        override var id: String,
        seasonNumber: Int,
        episodeNumber: Int,
        override var extendedInfo: TraktExtendedInfo? = null
) : AEpisodeRequest<TraktEpisodeImpl>(
        "shows/{id}/seasons/{season}/episodes/{episode}{?extended}",
        id,
        seasonNumber,
        episodeNumber,
        TraktEpisodeImpl::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}

internal class EpisodeTranslationsRequest(
        override var id: String,
        seasonNumber: Int,
        episodeNumber: Int,
        internal var languageCode: String? = null
) : AEpisodeRequest<TraktEpisodeImpl>(
        "shows/{id}/seasons/{season}/episodes/{episode}/translations{/language}",
        id,
        seasonNumber,
        episodeNumber,
        TraktEpisodeImpl::class
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
        seasonNumber: Int,
        episodeNumber: Int,
        override var extendedInfo: TraktExtendedInfo? = null
) : AEpisodeRequest<TraktUserImpl>(
        "shows/{id}/seasons/{season}/episodes/{episode}/watching{?extended}",
        id,
        seasonNumber,
        episodeNumber,
        TraktUserImpl::class
), ISupportsExtendedInfo {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
        }
}