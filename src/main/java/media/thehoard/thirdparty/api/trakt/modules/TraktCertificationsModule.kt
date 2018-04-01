package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCertificationsImpl
import media.thehoard.thirdparty.api.trakt.requests.certifications.MovieCertificationsRequest
import media.thehoard.thirdparty.api.trakt.requests.certifications.ShowCertificationsRequest
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.util.concurrent.CompletableFuture

class TraktCertificationsModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getMovieCertificationsAsync(): CompletableFuture<TraktResponse<TraktCertificationsImpl>> {
        return RequestHandler(client).executeSingleItemRequestAsync(MovieCertificationsRequest())
    }

    fun getShowCertificationsAsync(): CompletableFuture<TraktResponse<TraktCertificationsImpl>> {
        return RequestHandler(client).executeSingleItemRequestAsync(ShowCertificationsRequest())
    }
}
