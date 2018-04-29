package com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShowAirs
import java.time.DayOfWeek
import java.time.LocalTime
import java.time.ZoneId

data class TraktShowAirsImpl(
        override var day: DayOfWeek? = null,
        override var time: LocalTime? = null,
        override var timezone: ZoneId? = null
) : TraktShowAirs
