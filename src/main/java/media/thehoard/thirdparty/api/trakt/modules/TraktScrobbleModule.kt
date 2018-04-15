package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.implementations.TraktEpisodeScrobblePostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.implementations.TraktMovieScrobblePostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses.TraktMovieScrobblePostResponse
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.requests.scrobbles.ScrobblePauseRequest
import media.thehoard.thirdparty.api.trakt.requests.scrobbles.ScrobbleStartRequest
import media.thehoard.thirdparty.api.trakt.requests.scrobbles.ScrobbleStopRequest
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.time.LocalDate
import java.util.concurrent.CompletableFuture

class TraktScrobbleModule internal constructor(override val client: TraktClient) : TraktModule {
    fun startMovieAsync(
            movie: TraktMovie,
            progress: Float,
            appVersion: String? = null,
            appBuildDate: LocalDate? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktMovieScrobblePostResponse>> {
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
    ): CompletableFuture<TraktResponse<TraktMovieScrobblePostResponse>> {
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
    ): CompletableFuture<TraktResponse<TraktMovieScrobblePostResponse>> {
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
    ): CompletableFuture<TraktResponse<TraktMovieScrobblePostResponse>> {
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
    ): CompletableFuture<TraktResponse<TraktMovieScrobblePostResponse>> {
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
    ): CompletableFuture<TraktResponse<TraktMovieScrobblePostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(
                ScrobbleStopRequest(
                        TraktEpisodeScrobblePostImpl(
                                progress, appVersion, appBuildDate.toString(),
                                TraktEpisodeImpl(episode.season, episode.number, ids = episode.ids),
                                if (show != null) TraktShowImpl(show.title) else null
                        ), TraktMovieScrobblePostResponse::class), requestAuthorization)
    }
}
