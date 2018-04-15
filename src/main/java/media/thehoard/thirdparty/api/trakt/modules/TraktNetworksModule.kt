package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktNetwork
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.requests.networks.NetworksRequest
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import java.util.concurrent.CompletableFuture

class TraktNetworksModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getNetworksAsync(requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktListResponse<TraktNetwork>> {
        return RequestHandler(client).executeListRequestAsync(NetworksRequest(), requestAuthorization)
    }
}
