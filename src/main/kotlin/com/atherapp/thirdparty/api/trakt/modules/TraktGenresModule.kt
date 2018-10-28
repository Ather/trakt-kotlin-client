package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.enums.TraktGenreType
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktGenre
import com.atherapp.thirdparty.api.trakt.requests.genres.GenresMoviesRequest
import com.atherapp.thirdparty.api.trakt.requests.genres.GenresShowsRequest
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.responses.TraktListResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class TraktGenresModule(override val client: TraktClient) : TraktModule {
    fun getMovieGenresAsync(requestAuthorization: TraktAuthorization = client.authorization): Deferred<TraktListResponse<TraktGenre>> = GlobalScope.async {
        return@async RequestHandler(client).executeListRequestAsync(GenresMoviesRequest(), requestAuthorization).await().also {
            if (it.hasValue && it.value != null)
                it.value!!.forEach { genre -> genre.type = TraktGenreType.MOVIES }
        }
    }

    fun getShowGenresAsync(requestAuthorization: TraktAuthorization = client.authorization): Deferred<TraktListResponse<TraktGenre>> = GlobalScope.async {
        return@async RequestHandler(client).executeListRequestAsync(GenresShowsRequest(), requestAuthorization).await().also {
            if (it.hasValue && it.value != null)
                it.value!!.forEach { genre -> genre.type = TraktGenreType.SHOWS }
        }
    }
}
