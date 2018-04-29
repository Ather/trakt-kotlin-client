package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktCertifications
import com.atherapp.thirdparty.api.trakt.requests.certifications.MovieCertificationsRequest
import com.atherapp.thirdparty.api.trakt.requests.certifications.ShowCertificationsRequest
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import java.util.concurrent.CompletableFuture

class TraktCertificationsModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getMovieCertificationsAsync(requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktResponse<TraktCertifications>> {
        return RequestHandler(client).executeSingleItemRequestAsync(MovieCertificationsRequest(), requestAuthorization)
    }

    fun getShowCertificationsAsync(requestAuthorization: TraktAuthorization = client.authorization): CompletableFuture<TraktResponse<TraktCertifications>> {
        return RequestHandler(client).executeSingleItemRequestAsync(ShowCertificationsRequest(), requestAuthorization)
    }
}
