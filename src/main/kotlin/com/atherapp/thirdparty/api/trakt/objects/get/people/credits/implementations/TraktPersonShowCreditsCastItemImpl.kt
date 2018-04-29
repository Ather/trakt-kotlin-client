package com.atherapp.thirdparty.api.trakt.objects.get.people.credits.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCastItem
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

data class TraktPersonShowCreditsCastItemImpl(
        override var character: String = "",
        override var show: TraktShow = TraktShowImpl()
) : TraktPersonShowCreditsCastItem
