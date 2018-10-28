package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.implementations.TraktEpisodeScrobblePostImpl
import com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.implementations.TraktMovieScrobblePostImpl
import com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.responses.TraktMovieScrobblePostResponse
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.requests.scrobbles.ScrobblePauseRequest
import com.atherapp.thirdparty.api.trakt.requests.scrobbles.ScrobbleStartRequest
import com.atherapp.thirdparty.api.trakt.requests.scrobbles.ScrobbleStopRequest
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import kotlinx.coroutines.Deferred
import java.time.LocalDate

class TraktScrobbleModule internal constructor(override val client: TraktClient) : TraktModule {
    fun startMovieAsync(
            movie: TraktMovie,
            progress: Float,
            appVersion: String? = null,
            appBuildDate: LocalDate? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktMovieScrobblePostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(
                ScrobbleStartRequest(
                        TraktMovieScrobblePostImpl(
                                progress, appVersion, appBuildDate.toString(),
                                TraktMovieImpl(movie.title, movie.year, movie.ids)
                        ), TraktMovieScrobblePostResponse::class), requestAuthorization)
    }

    fun pauseMovieAsync(
            movie: TraktMovie,
            progress: Float,
            appVersion: String? = null,
            appBuildDate: LocalDate? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktMovieScrobblePostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(
                ScrobblePauseRequest(
                        TraktMovieScrobblePostImpl(
                                progress, appVersion, appBuildDate.toString(),
                                TraktMovieImpl(movie.title, movie.year, movie.ids)
                        ), TraktMovieScrobblePostResponse::class), requestAuthorization)
    }

    fun stopMovieAsync(
            movie: TraktMovie,
            progress: Float,
            appVersion: String? = null,
            appBuildDate: LocalDate? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktMovieScrobblePostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(
                ScrobbleStopRequest(
                        TraktMovieScrobblePostImpl(
                                progress, appVersion, appBuildDate.toString(),
                                TraktMovieImpl(movie.title, movie.year, movie.ids)
                        ), TraktMovieScrobblePostResponse::class), requestAuthorization)
    }

    fun startEpisodeAsync(
            episode: TraktEpisode,
            show: TraktShow? = null,
            progress: Float,
            appVersion: String? = null,
            appBuildDate: LocalDate? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktMovieScrobblePostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(
                ScrobbleStartRequest(
                        TraktEpisodeScrobblePostImpl(
                                progress, appVersion, appBuildDate.toString(),
                                TraktEpisodeImpl(episode.season, episode.number, ids = episode.ids),
                                if (show != null) TraktShowImpl(show.title) else null
                        ), TraktMovieScrobblePostResponse::class), requestAuthorization)
    }

    fun pauseEpisodeAsync(
            episode: TraktEpisode,
            show: TraktShow? = null,
            progress: Float,
            appVersion: String? = null,
            appBuildDate: LocalDate? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktMovieScrobblePostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(
                ScrobblePauseRequest(
                        TraktEpisodeScrobblePostImpl(
                                progress, appVersion, appBuildDate.toString(),
                                TraktEpisodeImpl(episode.season, episode.number, ids = episode.ids),
                                if (show != null) TraktShowImpl(show.title) else null
                        ), TraktMovieScrobblePostResponse::class), requestAuthorization)
    }

    fun stopEpisodeAsync(
            episode: TraktEpisode,
            show: TraktShow? = null,
            progress: Float,
            appVersion: String? = null,
            appBuildDate: LocalDate? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktMovieScrobblePostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(
                ScrobbleStopRequest(
                        TraktEpisodeScrobblePostImpl(
                                progress, appVersion, appBuildDate.toString(),
                                TraktEpisodeImpl(episode.season, episode.number, ids = episode.ids),
                                if (show != null) TraktShowImpl(show.title) else null
                        ), TraktMovieScrobblePostResponse::class), requestAuthorization)
    }
}
