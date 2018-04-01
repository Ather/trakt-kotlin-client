package media.thehoard.thirdparty.api.trakt.requests.calendars

import media.thehoard.thirdparty.api.trakt.extensions.toTraktDateString
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.implementations.TraktCalendarShowImpl
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsFilter
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktCommonFilter
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.time.Instant

internal abstract class ACalendarRequest<TResponseConentType> : AGetRequestHasResponse<TResponseConentType>(), ISupportsExtendedInfo, ISupportsFilter {
    internal var startDate: Instant? = null

    internal var days: Int? = null

    override var extendedInfo: TraktExtendedInfo? = null

    override var filter: TraktCommonFilter? = null

    override val uriPathParameters: Map<String, Any>? = hashMapOf<String, String>().apply {
        if (startDate != null)
            this["start_date"] = startDate!!.toTraktDateString()
        if (days != null) {
            this["days"] = days!!.toString()
            if (startDate == null)
                this["start_date"] = Instant.now().toTraktDateString()
        }

        if (extendedInfo?.hasAnySet == true)
            this["extended"] = extendedInfo.toString()

        if (filter?.hasValues == true)
            for (parameter in filter!!.getParameters())
                this[parameter.key] = parameter.value
    }

    override fun validate() {
        if (days != null && days!! !in 1..31)
            throw IllegalArgumentException("days must have a value between 1 and 31")
    }
}

internal class CalendarAllDVDMoviesRequest : ACalendarRequest<TraktCalendarMovieImpl>() {
    override val uriTemplate: String
        get() = "calendars/all/dvd{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}"
}

internal class CalendarAllMoviesRequest : ACalendarRequest<TraktCalendarMovieImpl>() {
    override val uriTemplate: String
        get() = "calendars/all/movies{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}"
}

internal class CalendarAllNewShowsRequest : ACalendarRequest<TraktCalendarShowImpl>() {
    override val uriTemplate: String
        get() = "calendars/all/shows/new{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}"
}

internal class CalendarAllSeasonPremieresRequest : ACalendarRequest<TraktCalendarShowImpl>() {
    override val uriTemplate: String
        get() = "calendars/all/shows/premieres{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}"
}

internal class CalendarAllShowsRequest : ACalendarRequest<TraktCalendarShowImpl>() {
    override val uriTemplate: String
        get() = "calendars/all/shows{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}"
}