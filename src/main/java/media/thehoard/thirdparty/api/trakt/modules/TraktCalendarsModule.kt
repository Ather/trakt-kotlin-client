package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarShowImpl
import media.thehoard.thirdparty.api.trakt.requests.calendars.*
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktCalendarFilter
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import java.time.Instant
import java.util.concurrent.CompletableFuture

class TraktCalendarsModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getUserShowsAsync(
            startDate: Instant? = null,
            days: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktCalendarFilter? = null
    ): CompletableFuture<TraktListResponse<TraktCalendarShowImpl>> {
        return RequestHandler(client).executeListRequestAsync(CalendarUserShowsRequest().apply {
            this.startDate = startDate
            this.days = days
            this.extendedInfo = extendedInfo
            this.filter = filter
        })
    }

    fun getUserNewShowsAsync(
            startDate: Instant? = null,
            days: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktCalendarFilter? = null
    ) : CompletableFuture<TraktListResponse<TraktCalendarShowImpl>> {
        return RequestHandler(client).executeListRequestAsync(CalendarUserNewShowsRequest().apply {
            this.startDate = startDate
            this.days = days
            this.extendedInfo = extendedInfo
            this.filter = filter
        })
    }

    fun getUserSeasonPremiereAsync(
            startDate: Instant? = null,
            days: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktCalendarFilter? = null
    ) : CompletableFuture<TraktListResponse<TraktCalendarShowImpl>> {
        return RequestHandler(client).executeListRequestAsync(CalendarUserSeasonPremieresRequest().apply {
            this.startDate = startDate
            this.days = days
            this.extendedInfo = extendedInfo
            this.filter = filter
        })
    }

    fun getUserMoviesAsync(
            startDate: Instant? = null,
            days: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktCalendarFilter? = null
    ) : CompletableFuture<TraktListResponse<TraktCalendarMovieImpl>> {
        return RequestHandler(client).executeListRequestAsync(CalendarUserMoviesRequest().apply {
            this.startDate = startDate
            this.days = days
            this.extendedInfo = extendedInfo
            this.filter = filter
        })
    }

    fun getUserDVDMoviesAsync(
            startDate: Instant? = null,
            days: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktCalendarFilter? = null
    ) : CompletableFuture<TraktListResponse<TraktCalendarMovieImpl>> {
        return RequestHandler(client).executeListRequestAsync(CalendarUserDVDMoviesRequest().apply {
            this.startDate = startDate
            this.days = days
            this.extendedInfo = extendedInfo
            this.filter = filter
        })
    }

    fun getAllShowsAsync(
            startDate: Instant? = null,
            days: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktCalendarFilter? = null
    ) : CompletableFuture<TraktListResponse<TraktCalendarShowImpl>> {
        return RequestHandler(client).executeListRequestAsync(CalendarAllShowsRequest().apply {
            this.startDate = startDate
            this.days = days
            this.extendedInfo = extendedInfo
            this.filter = filter
        })
    }

    fun getAllNewShowsAsync(
            startDate: Instant? = null,
            days: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktCalendarFilter? = null
    ) : CompletableFuture<TraktListResponse<TraktCalendarShowImpl>> {
        return RequestHandler(client).executeListRequestAsync(CalendarAllNewShowsRequest().apply {
            this.startDate = startDate
            this.days = days
            this.extendedInfo = extendedInfo
            this.filter = filter
        })
    }

    fun getAllSeasonPremieresAsync(
            startDate: Instant? = null,
            days: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktCalendarFilter? = null
    ) : CompletableFuture<TraktListResponse<TraktCalendarShowImpl>> {
        return RequestHandler(client).executeListRequestAsync(CalendarAllShowsRequest().apply {
            this.startDate = startDate
            this.days = days
            this.extendedInfo = extendedInfo
            this.filter = filter
        })
    }

    fun getAllMoviesAsync(
            startDate: Instant? = null,
            days: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktCalendarFilter? = null
    ) : CompletableFuture<TraktListResponse<TraktCalendarMovieImpl>> {
        return RequestHandler(client).executeListRequestAsync(CalendarAllMoviesRequest().apply {
            this.startDate = startDate
            this.days = days
            this.extendedInfo = extendedInfo
            this.filter = filter
        })
    }

    fun getAllDVDMoviesAsync(
            startDate: Instant? = null,
            days: Int? = null,
            extendedInfo: TraktExtendedInfo? = null,
            filter: TraktCalendarFilter? = null
    ) : CompletableFuture<TraktListResponse<TraktCalendarMovieImpl>> {
        return RequestHandler(client).executeListRequestAsync(CalendarAllDVDMoviesRequest().apply {
            this.startDate = startDate
            this.days = days
            this.extendedInfo = extendedInfo
            this.filter = filter
        })
    }
}
