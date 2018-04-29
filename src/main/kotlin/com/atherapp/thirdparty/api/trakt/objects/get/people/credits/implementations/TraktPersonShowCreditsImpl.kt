package com.atherapp.thirdparty.api.trakt.objects.get.people.credits.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCredits
import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCastItem
import com.atherapp.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCrew

data class TraktPersonShowCreditsImpl(
        override var cast: List<TraktPersonShowCreditsCastItem> = listOf(),
        override var crew: TraktPersonShowCreditsCrew = TraktPersonShowCreditsCrewImpl()
) : TraktPersonShowCredits
