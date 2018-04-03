package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.extensions.toTraktDateString
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.implementations.TraktEpisodeCheckinPostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.implementations.TraktMovieCheckinPostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations.TraktEpisodeCheckinPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations.TraktMovieCheckinPostResponseImpl
import media.thehoard.thirdparty.api.trakt.requests.checkins.CheckinRequest
import media.thehoard.thirdparty.api.trakt.requests.checkins.CheckinsDeleteRequest
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.time.Instant
import java.util.concurrent.CompletableFuture

class TraktCheckinModule(override val client: TraktClient) : TraktModule {

    fun checkIntoMovieAsync(
            movie: TraktMovieImpl,
            appVersion: String? = null,
            appBuildDate: Instant? = null,
            message: String? = null,
            sharing: TraktSharingImpl? = null,
            foursquareVenueID: String? = null,
            foursquareVenueName: String? = null
    ): CompletableFuture<TraktResponse<TraktMovieCheckinPostResponseImpl>> {
        validate(movie)

        val requestBody = TraktMovieCheckinPostImpl(
                movie = TraktMovieImpl(
                        title = movie.title,
                        year = movie.year,
                        ids = movie.ids),
                message = message,
                sharing = sharing,
                foursquareVenueId = foursquareVenueID,
                foursquareVenueName = foursquareVenueName
        )

        if (appVersion.isNullOrBlank())
            requestBody.appVersion = appVersion

        if (appBuildDate != null)
            requestBody.appDate = appBuildDate.toTraktDateString()

        return RequestHandler(client).executeSingleItemRequestAsync(CheckinRequest(requestBody))
    }

    fun checkIntoEpisodeAsync(
            episode: TraktEpisodeImpl,
            show: TraktShowImpl? = null,
            appVersion: String? = null,
            appBuildDate: Instant? = null,
            message: String? = null,
            sharing: TraktSharingImpl? = null,
            foursquareVenueID: String? = null,
            foursquareVenueName: String? = null
    ): CompletableFuture<TraktResponse<TraktEpisodeCheckinPostResponseImpl>> {
        if (show != null)
            validate(episode, show)
        else
            validate(episode)

        val requestBody = TraktEpisodeCheckinPostImpl(
                episode = TraktEpisodeImpl(
                        ids = episode.ids,
                        season = episode.season,
                        number = episode.number
                ),
                show = if (show == null) null else TraktShowImpl(title = show.title),
                message = message,
                sharing = sharing,
                foursquareVenueId = foursquareVenueID,
                foursquareVenueName = foursquareVenueName
        )

        if (!appVersion.isNullOrBlank())
            requestBody.appVersion = appVersion

        if (appBuildDate != null)
            requestBody.appDate = appBuildDate.toTraktDateString()

        return RequestHandler(client).executeSingleItemRequestAsync(CheckinRequest(requestBody))
    }

    fun deleteAnyActiveCheckinsAsync(): CompletableFuture<TraktNoContentResponse> =
            RequestHandler(client).executeNoContentRequestAsync(CheckinsDeleteRequest())

    private fun validate(movie: TraktMovie) {
        if (movie.title.isBlank())
            throw IllegalArgumentException("movie title not valid")

        if (movie.year!! <= 0 || movie.year!!.toString().length != 4)
            throw IllegalArgumentException("movie year not valid")

        if (!movie.ids.hasAnyId())
            throw IllegalArgumentException("movie.ids have no valid id")
    }

    private fun validate(episode: TraktEpisode) {
        if (!episode.ids.hasAnyId())
            throw IllegalArgumentException("episode.ids have no valid id")
    }

    private fun validate(episode: TraktEpisode, show: TraktShow) {
        if (episode.season!! < 0)
            throw IllegalArgumentException("episode season number not valid")

        if (episode.number!! < 0)
            throw IllegalArgumentException("episode number not valid")

        if (show.title.isBlank())
            throw IllegalArgumentException("show title not valid")
    }
}
