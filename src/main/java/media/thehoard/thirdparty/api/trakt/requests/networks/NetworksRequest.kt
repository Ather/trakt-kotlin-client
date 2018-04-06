package media.thehoard.thirdparty.api.trakt.requests.networks

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktNetworkImpl
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse

internal class NetworksRequest : AGetRequestHasResponse<TraktNetworkImpl>(TraktNetworkImpl::class) {
    override val uriTemplate: String = "networks"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()

    override fun validate() {}
}