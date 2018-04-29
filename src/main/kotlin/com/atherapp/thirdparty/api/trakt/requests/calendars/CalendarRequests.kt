package com.atherapp.thirdparty.api.trakt.requests.calendars

import com.atherapp.thirdparty.api.trakt.extensions.toTraktDateString
import com.atherapp.thirdparty.api.trakt.extensions.validate
import com.atherapp.thirdparty.api.trakt.objects.get.calendars.TraktCalendarMovie
import com.atherapp.thirdparty.api.trakt.objects.get.calendars.TraktCalendarShow
import com.atherapp.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import com.atherapp.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import com.atherapp.thirdparty.api.trakt.requests.interfaces.ISupportsFilter
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktCommonFilter
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.time.ZonedDateTime
import kotlin.reflect.KClass

internal abstract class ACalendarRequest<TResponseConentType : Any>(override val uriTemplate: String, responseContentClass: KClass<TResponseConentType>) : AGetRequestHasResponse<TResponseConentType>(responseContentClass), ISupportsExtendedInfo, ISupportsFilter {
    internal abstract var startDate: ZonedDateTime?

    internal abstract var days: Int?

    abstract override var extendedInfo: TraktExtendedInfo?

    abstract  override var filter: TraktCommonFilter?

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

internal class CalendarAllDVDMoviesRequest(
        override var startDate: ZonedDateTime?,
        override var days: Int?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?
) : ACalendarRequest<TraktCalendarMovie>("calendars/all/dvd{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarMovie::class)

internal class CalendarAllMoviesRequest(
        override var startDate: ZonedDateTime?,
        override var days: Int?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?
) : ACalendarRequest<TraktCalendarMovie>("calendars/all/movies{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarMovie::class)

internal class CalendarAllNewShowsRequest(
        override var startDate: ZonedDateTime?,
        override var days: Int?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?
) : ACalendarRequest<TraktCalendarShow>("calendars/all/shows/new{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarShow::class)

internal class CalendarAllSeasonPremieresRequest(
        override var startDate: ZonedDateTime?,
        override var days: Int?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?
) : ACalendarRequest<TraktCalendarShow>("calendars/all/shows/premieres{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarShow::class)

internal class CalendarAllShowsRequest(
        override var startDate: ZonedDateTime?,
        override var days: Int?,
        override var extendedInfo: TraktExtendedInfo?,
        override var filter: TraktCommonFilter?
) : ACalendarRequest<TraktCalendarShow>("calendars/all/shows{/start_date}{/days}{?extended,query,years,genres,languages,countries,runtimes,ratings}", TraktCalendarShow::class)