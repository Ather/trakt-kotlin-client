package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCertifications
import media.thehoard.thirdparty.api.trakt.requests.certifications.MovieCertificationsRequest
import media.thehoard.thirdparty.api.trakt.requests.certifications.ShowCertificationsRequest
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.util.concurrent.CompletableFuture

class TraktCertificationsModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getMovieCertificationsAsync(requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktResponse<TraktCertifications>> {
        return RequestHandler(client).executeSingleItemRequestAsync(MovieCertificationsRequest(), requestAuthorization)
    }

    fun getShowCertificationsAsync(requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktResponse<TraktCertifications>> {
        return RequestHandler(client).executeSingleItemRequestAsync(ShowCertificationsRequest(), requestAuthorization)
    }
}
