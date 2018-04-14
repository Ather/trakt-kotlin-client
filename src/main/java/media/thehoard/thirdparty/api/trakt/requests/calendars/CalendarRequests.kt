package media.thehoard.thirdparty.api.trakt.requests.calendars

import media.thehoard.thirdparty.api.trakt.extensions.toTraktDateString
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarMovie
import media.thehoard.thirdparty.api.trakt.objects.get.calendars.TraktCalendarShow
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsFilter
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktCommonFilter
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.time.ZonedDateTime
import kotlin.reflect.KClass

internal abstract class ACalendarRequest<TResponseConentType>(override val uriTemplate: String, responseContentClass: KClass<*>) : AGetRequestHasResponse<TResponseConentType>(responseContentClass), ISupportsExtendedInfo, ISupportsFilter {
    internal var startDate: ZonedDateTime? = null

    internal var days: Int? = null

    override var extendedInfo: TraktExtendedInfo? = null

    override var filter: TraktCommonFilter? = null

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf<String, String>().apply {
            if (startDate != null)
                this["start_date"] = startDate!!.toTraktDateString()
            if (days != null) {
                this["days"] = days!!.toString()
                if (startDate == null)
                    this["start_date"] = ZonedDateTime.now().toTraktDateString()
            }

            if (extendedInfo?.hasAnySet == true)
                this["extended"] = extendedInfo.toString()

            if (filter?.hasValues == true)
                for (parameter in filter!!.getParameters())
                    this[parameter.key] = parameter.value
        }

    override fun validate(variableName: String) = (days ?: 0 in 1..31).validate("days must have a value between 1 and 31", null)
}

internal class CalendarAllDVDMoviesRequest : ACalendarRequest<TraktCalendarMovie>("calendars/all/dvd{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarMovie::class)

internal class CalendarAllMoviesRequest : ACalendarRequest<TraktCalendarMovie>("calendars/all/movies{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarMovie::class)

internal class CalendarAllNewShowsRequest : ACalendarRequest<TraktCalendarShow>("calendars/all/shows/new{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarShow::class)

internal class CalendarAllSeasonPremieresRequest : ACalendarRequest<TraktCalendarShow>("calendars/all/shows/premieres{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarShow::class)

internal class CalendarAllShowsRequest : ACalendarRequest<TraktCalendarShow>("calendars/all/shows{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarShow::class)