package media.thehoard.thirdparty.api.trakt.requests.shows

import media.thehoard.thirdparty.api.trakt.extensions.isValidStringId
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowCollectionProgress
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.base.AuthorizationRequirement
import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import kotlin.reflect.KClass

internal sealed class AShowProgressRequest<TResponseContentType : Any>(
        override val uriTemplate: String,
        responseContentClass: KClass<TResponseContentType>
) : AGetRequestHasResponse<TResponseContentType>(responseContentClass), IHasId {
    internal abstract var hidden: Boolean?

    internal abstract var specials: Boolean?

    internal abstract var countSpecials: Boolean?

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
        override var hidden: Boolean?,
        override var specials: Boolean?,
        override var countSpecials: Boolean?
) : AShowProgressRequest<TraktShowCollectionProgress>(
        "shows/{id}/progress/collection{?hidden,specials,count_specials}",
        TraktShowCollectionProgress::class
)

internal class ShowWatchedProgressRequest(
        override var id: String,
        override var hidden: Boolean?,
        override var specials: Boolean?,
        override var countSpecials: Boolean?
) : AShowProgressRequest<TraktShowCollectionProgress>(
        "shows/{id}/progress/watched{?hidden,specials,count_specials}",
        TraktShowCollectionProgress::class
)