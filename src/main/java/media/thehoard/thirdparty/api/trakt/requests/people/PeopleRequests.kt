package media.thehoard.thirdparty.api.trakt.requests.people

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonMovieCreditsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonShowCreditsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import kotlin.reflect.KClass

internal sealed class APersonRequest<TResponseContentType>(
        override val uriTemplate: String,
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null,
        responseContentClass: KClass<*>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), IHasId, ISupportsExtendedInfo {
    override val requestObjectType: RequestObjectType = RequestObjectType.People

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id).apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo.toString()
        }

    override fun validate() {}
}

internal class PersonMovieCreditsRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null
) : APersonRequest<TraktPersonMovieCreditsImpl>(
        "people/{id}/movies{?extended}",
        id,
        extendedInfo,
        TraktPersonMovieCreditsImpl::class
)

internal class PersonShowCreditsRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null
) : APersonRequest<TraktPersonShowCreditsImpl>(
        "people/{id}/shows{?extended}",
        id,
        extendedInfo,
        TraktPersonShowCreditsImpl::class
)

internal class PersonSummaryRequest(
        override var id: String,
        override var extendedInfo: TraktExtendedInfo? = null
) : APersonRequest<TraktPersonImpl>(
        "people/{id}{?extended}",
        id,
        extendedInfo,
        TraktPersonImpl::class
)