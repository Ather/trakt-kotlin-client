package com.atherapp.thirdparty.api.trakt.objects.get.people.credits.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCrewItem
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

data class TraktPersonShowCreditsCrewItemImpl(
        override var job: String = "",
        override var show: TraktShow = TraktShowImpl()
) : TraktPersonShowCreditsCrewItem
