package media.thehoard.thirdparty.api.trakt.requests.calendars

import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarMovie
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarShow
import media.thehoard.thirdparty.api.trakt.requests.base.AuthorizationRequirement
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktCommonFilter
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.time.ZonedDateTime
import kotlin.reflect.KClass

internal sealed class ACalendarUserRequest<TResponseContentType>(override val uriTemplate: String, responseContentClass: KClass<*>) : ACalendarRequest<TResponseContentType>(uriTemplate, responseContentClass) {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required
}

internal class CalendarUserDVDMoviesRequest(
        override var startDate: ZonedDateTime?,
        override var days: Int?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?
) : ACalendarUserRequest<TraktCalendarMovie>("calendars/my/dvd{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarMovie::class)

internal class CalendarUserMoviesRequest(
        override var startDate: ZonedDateTime?,
        override var days: Int?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?
) : ACalendarUserRequest<TraktCalendarMovie>("calendars/my/movies{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarMovie::class)

internal class CalendarUserNewShowsRequest(
        override var startDate: ZonedDateTime?,
        override var days: Int?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?
) : ACalendarUserRequest<TraktCalendarShow>("calendars/my/shows/new{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarShow::class)

internal class CalendarUserSeasonPremieresRequest(
        override var startDate: ZonedDateTime?,
        override var days: Int?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?
) : ACalendarUserRequest<TraktCalendarShow>("calendars/my/shows/premieres{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarShow::class)

internal class CalendarUserShowsRequest(
        override var startDate: ZonedDateTime?,
        override var days: Int?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?
) : ACalendarUserRequest<TraktCalendarShow>("calendars/my/shows{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarShow::class)