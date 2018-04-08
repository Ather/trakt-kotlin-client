package media.thehoard.thirdparty.api.trakt.requests.shows

import media.thehoard.thirdparty.api.trakt.extensions.isValidStringId
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowCollectionProgressImpl
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.base.AuthorizationRequirement
import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import kotlin.reflect.KClass

internal sealed class AShowProgressRequest<TResponseContentType>(
        override val uriTemplate: String,
        override var id: String,
        internal var hidden: Boolean? = null,
        internal var specials: Boolean? = null,
        internal var countSpecials: Boolean? = null,
        responseContentClass: KClass<*>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), IHasId {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required

    override val requestObjectType: RequestObjectType = RequestObjectType.Shows

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("id" to id).apply {
            if (hidden != null)
                this["hidden"] = hidden!!.toString()
            if (specials != null)
                this["specials"] = specials!!.toString()
            if (countSpecials != null)
                this["count_specials"] = countSpecials!!.toString()
        }

    override fun validate(variableName: String) = id.validate("show id", ::isValidStringId)
}

internal class ShowCollectionProgressRequest(
        override var id: String,
        hidden: Boolean? = null,
        specials: Boolean? = null,
        countSpecials: Boolean? = null
) : AShowProgressRequest<TraktShowCollectionProgressImpl>(
        "shows/{id}/progress/collection{?hidden,specials,count_specials}",
        id,
        hidden,
        specials,
        countSpecials,
        TraktShowCollectionProgressImpl::class
)

internal class ShowWatchedProgressRequest(
        override var id: String,
        hidden: Boolean? = null,
        specials: Boolean? = null,
        countSpecials: Boolean? = null
) : AShowProgressRequest<TraktShowCollectionProgressImpl>(
        "shows/{id}/progress/watched{?hidden,specials,count_specials}",
        id,
        hidden,
        specials,
        countSpecials,
        TraktShowCollectionProgressImpl::class
)