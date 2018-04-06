package media.thehoard.thirdparty.api.trakt.requests.calendars

import media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarShowImpl
import media.thehoard.thirdparty.api.trakt.requests.base.AuthorizationRequirement
import kotlin.reflect.KClass

internal sealed class ACalendarUserRequest<TResponseContentType>(override val uriTemplate: String, responseContentClass: KClass<*>) : ACalendarRequest<TResponseContentType>(uriTemplate, responseContentClass) {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required
}

internal class CalendarUserDVDMoviesRequest : ACalendarUserRequest<TraktCalendarMovieImpl>("calendars/my/dvd{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarMovieImpl::class)

internal class CalendarUserMoviesRequest : ACalendarUserRequest<TraktCalendarMovieImpl>("calendars/my/movies{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarMovieImpl::class)

internal class CalendarUserNewShowsRequest : ACalendarUserRequest<TraktCalendarShowImpl>("calendars/my/shows/new{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarShowImpl::class)

internal class CalendarUserSeasonPremieresRequest : ACalendarUserRequest<TraktCalendarShowImpl>("calendars/my/shows/premieres{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarShowImpl::class)

internal class CalendarUserShowsRequest : ACalendarUserRequest<TraktCalendarShowImpl>("calendars/my/shows{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarShowImpl::class)