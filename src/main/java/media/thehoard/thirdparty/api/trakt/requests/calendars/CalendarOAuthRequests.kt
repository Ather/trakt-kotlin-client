package media.thehoard.thirdparty.api.trakt.requests.calendars

import media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarShowImpl
import media.thehoard.thirdparty.api.trakt.requests.base.AuthorizationRequirement

internal sealed class ACalendarUserRequest<TResponseContentType> : ACalendarRequest<TResponseContentType>() {
    override val authorizationRequirement: AuthorizationRequirement
        get() = AuthorizationRequirement.Required
}

internal class CalendarUserDVDMoviesRequest : ACalendarUserRequest<TraktCalendarMovieImpl>() {
    override val uriTemplate: String
        get() = "calendars/my/dvd{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}"
}

internal class CalendarUserMoviesRequest : ACalendarUserRequest<TraktCalendarMovieImpl>() {
    override val uriTemplate: String
        get() = "calendars/my/movies{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}"
}

internal class CalendarUserNewShowsRequest: ACalendarUserRequest<TraktCalendarShowImpl>() {
    override val uriTemplate: String
        get() = "calendars/my/shows/new{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}"
}

internal class CalendarUserSeasonPremieresRequest: ACalendarUserRequest<TraktCalendarShowImpl>() {
    override val uriTemplate: String
        get() = "calendars/my/shows/premieres{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}"
}

internal class CalendarUserShowsRequest: ACalendarUserRequest<TraktCalendarShowImpl>() {
    override val uriTemplate: String
        get() = "calendars/my/shows{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}"
}