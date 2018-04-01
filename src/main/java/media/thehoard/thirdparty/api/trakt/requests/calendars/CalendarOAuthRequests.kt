package media.thehoard.thirdparty.api.trakt.requests.calendars

import media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarShowImpl
import media.thehoard.thirdparty.api.trakt.requests.base.AuthorizationRequirement

internal sealed class ACalendarUserRequest<TResponseContentType>(override val uriTemplate: String) : ACalendarRequest<TResponseContentType>(uriTemplate) {
    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.Required
}

internal class CalendarUserDVDMoviesRequest : ACalendarUserRequest<TraktCalendarMovieImpl>("calendars/my/dvd{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}")

internal class CalendarUserMoviesRequest : ACalendarUserRequest<TraktCalendarMovieImpl>("calendars/my/movies{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}")

internal class CalendarUserNewShowsRequest : ACalendarUserRequest<TraktCalendarShowImpl>("calendars/my/shows/new{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}")

internal class CalendarUserSeasonPremieresRequest : ACalendarUserRequest<TraktCalendarShowImpl>("calendars/my/shows/premieres{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}")

internal class CalendarUserShowsRequest : ACalendarUserRequest<TraktCalendarShowImpl>("calendars/my/shows{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}")