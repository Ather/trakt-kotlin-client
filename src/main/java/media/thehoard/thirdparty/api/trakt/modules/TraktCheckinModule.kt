package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.extensions.toTraktDateString
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
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
import java.time.ZonedDateTime
import java.util.concurrent.CompletableFuture

class TraktCheckinModule(override val client: TraktClient) : TraktModule {

    fun checkIntoMovieAsync(
            movie: TraktMovieImpl,
            appVersion: String? = null,
            appBuildDate: ZonedDateTime? = null,
            message: String? = null,
            sharing: TraktSharingImpl? = null,
            foursquareVenueID: String? = null,
            foursquareVenueName: String? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktMovieCheckinPostResponseImpl>> {
        movie.validate()

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

        return RequestHandler(client).executeSingleItemRequestAsync(CheckinRequest(requestBody, TraktMovieCheckinPostResponseImpl::class), requestAuthorization)
    }

    fun checkIntoEpisodeAsync(
            episode: TraktEpisodeImpl,
            show: TraktShowImpl? = null,
            appVersion: String? = null,
            appBuildDate: ZonedDateTime? = null,
            message: String? = null,
            sharing: TraktSharingImpl? = null,
            foursquareVenueID: String? = null,
            foursquareVenueName: String? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktEpisodeCheckinPostResponseImpl>> {
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

        return RequestHandler(client).executeSingleItemRequestAsync(CheckinRequest(requestBody, TraktEpisodeCheckinPostResponseImpl::class), requestAuthorization)
    }

    fun deleteAnyActiveCheckinsAsync(): CompletableFuture<TraktNoContentResponse> =
            RequestHandler(client).executeNoContentRequestAsync(CheckinsDeleteRequest())
}
