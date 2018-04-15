package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.extensions.toTraktDateString
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.implementations.TraktEpisodeCheckinPostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.implementations.TraktMovieCheckinPostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktEpisodeCheckinPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktMovieCheckinPostResponse
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations.TraktEpisodeCheckinPostResponseImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations.TraktMovieCheckinPostResponseImpl
import media.thehoard.thirdparty.api.trakt.requests.checkins.CheckinRequest
import media.thehoard.thirdparty.api.trakt.requests.checkins.CheckinsDeleteRequest
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.time.ZonedDateTime
import java.util.concurrent.CompletableFuture

class TraktCheckinModule internal constructor(override val client: TraktClient) : TraktModule {
    fun checkIntoMovieAsync(
            movie: TraktMovie,
            appVersion: String? = null,
            appBuildDate: ZonedDateTime? = null,
            message: String? = null,
            sharing: TraktSharing? = null,
            foursquareVenueID: String? = null,
            foursquareVenueName: String? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktMovieCheckinPostResponse>> {
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
            episode: TraktEpisode,
            show: TraktShow? = null,
            appVersion: String? = null,
            appBuildDate: ZonedDateTime? = null,
            message: String? = null,
            sharing: TraktSharing? = null,
            foursquareVenueID: String? = null,
            foursquareVenueName: String? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktEpisodeCheckinPostResponse>> {
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
