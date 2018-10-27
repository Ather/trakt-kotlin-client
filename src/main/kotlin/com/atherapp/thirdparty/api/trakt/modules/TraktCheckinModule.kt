package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.implementations.TraktEpisodeCheckinPostImpl
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.implementations.TraktMovieCheckinPostImpl
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.TraktEpisodeCheckinPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.TraktMovieCheckinPostResponse
import com.atherapp.thirdparty.api.trakt.requests.checkins.CheckinRequest
import com.atherapp.thirdparty.api.trakt.requests.checkins.CheckinsDeleteRequest
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.responses.TraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import kotlinx.coroutines.Deferred
import java.time.LocalDate
import java.time.ZonedDateTime

class TraktCheckinModule internal constructor(override val client: TraktClient) : TraktModule {
    fun checkIntoMovieAsync(
            movie: TraktMovie,
            appVersion: String? = null,
            appBuildDate: LocalDate? = null,
            message: String? = null,
            sharing: TraktSharing? = null,
            foursquareVenueID: String? = null,
            foursquareVenueName: String? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktMovieCheckinPostResponse>> {
        val requestBody = TraktMovieCheckinPostImpl(
                sharing, message, appVersion, appBuildDate.toString(), foursquareVenueID, foursquareVenueName,
                TraktMovieImpl(
                        movie.title,
                        movie.year,
                        movie.ids
                )
        )
        return RequestHandler(client).executeSingleItemRequestAsync(CheckinRequest(requestBody, TraktMovieCheckinPostResponse::class), requestAuthorization)
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
    ): Deferred<TraktResponse<TraktEpisodeCheckinPostResponse>> {
        val requestBody = TraktEpisodeCheckinPostImpl(
                sharing, message, appVersion, appBuildDate.toString(), foursquareVenueID, foursquareVenueName,
                TraktEpisodeImpl(
                        episode.season,
                        episode.number,
                        ids = episode.ids
                ),
                if (show == null) null else TraktShowImpl(show.title)
        )

        return RequestHandler(client).executeSingleItemRequestAsync(CheckinRequest(requestBody, TraktEpisodeCheckinPostResponse::class), requestAuthorization)
    }

    fun deleteAnyActiveCheckinsAsync(): Deferred<TraktNoContentResponse> =
            RequestHandler(client).executeNoContentRequestAsync(CheckinsDeleteRequest())
}
