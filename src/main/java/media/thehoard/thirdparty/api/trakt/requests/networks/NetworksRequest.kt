package media.thehoard.thirdparty.api.trakt.requests.networks

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktNetwork
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse

internal class NetworksRequest : AGetRequestHasResponse<TraktNetwork>(TraktNetwork::class) {
    override val uriTemplate: String = "networks"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf()

    override fun validate(variableName: String) {}
}